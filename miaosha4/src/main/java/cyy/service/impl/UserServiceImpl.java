package cyy.service.impl;

import cyy.dao.UserDOMapper;
import cyy.dao.UserPasswordDOMapper;
import cyy.dataobject.UserDO;
import cyy.dataobject.UserPasswordDO;
import cyy.error.BusinessException;
import cyy.error.EmBusinessError;
import cyy.service.UserService;
import cyy.service.model.UserModel;
import cyy.validator.ValidationResult;
import cyy.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.plaf.nimbus.NimbusStyle;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;
    @Autowired
    private ValidatorImpl validator;
    @Override
    public UserModel getUserById(Integer id) {
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);

        if (userDO == null) return null;

        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());
        return convertFromDataObject(userDO, userPasswordDO);

    }

    @Override
    @Transactional//让其成为事务，防止数据库不安全读写
    public void register(UserModel userModel) throws BusinessException {
        if(userModel==null) {throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);}
//        if(org.apache.commons.lang3.StringUtils.isEmpty(userModel.getName())||
//                userModel.getAge()==null||
//                userModel.getGender()==null||
//                org.apache.commons.lang3.StringUtils.isEmpty(userModel.getTelphone())
//                ){
//            throw  new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"入参不合法");
//        }
        ValidationResult validationResult = validator.validate(userModel);
        if(validationResult.isHasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,validationResult.getErrMsg());
        }
        //实现UserModel-->dataobject方法
        UserDO  userDO = converFromModel(userModel);
        try {
            userDOMapper.insertSelective(userDO);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"手机号已重复注册！");
        }
        //密码
        userModel.setId(userDO.getId());
        UserPasswordDO userPasswordDO=converPasswordFromModel(userModel);

            userPasswordDOMapper.insertSelective(userPasswordDO);

        return;

    }

    @Override
    public UserModel validateLogin(String telphone, String encrptPassword) throws BusinessException {
        //通过用户的手机获取用户信息
        UserDO userDO = userDOMapper.selectByTelphone(telphone);
        if(userDO==null) {
            throw new BusinessException(EmBusinessError.USER_LOGIN_ERROR);
        }
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());
        UserModel userModel = convertFromDataObject(userDO,userPasswordDO);

        //比对用户信息加密的密码是否和传输进来的匹配
        if(!org.apache.commons.lang3.StringUtils.equals(encrptPassword,userPasswordDO.getEncrptPassword())){
                throw  new BusinessException(EmBusinessError.USER_LOGIN_ERROR);
        }
        return userModel;
    }

    private UserPasswordDO converPasswordFromModel(UserModel userModel){
        if(userModel==null) return null;
        UserPasswordDO userPasswordDO = new UserPasswordDO();
        userPasswordDO.setEncrptPassword(userModel.getEncrptPassword());
        userPasswordDO.setUserId(userModel.getId());
        return  userPasswordDO;
    }

    private UserDO converFromModel(UserModel userModel){
        if(userModel==null) return null;
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userModel,userDO);
        return  userDO;
    }
    private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPasswordDO) {
        if (userDO == null) return null;
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO, userModel);
        if (userPasswordDO != null) {
            userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());

        }
        return userModel;
    }
}
