package cyy.controller;

import com.sun.corba.se.spi.copyobject.CopierManager;
import com.sun.xml.internal.rngom.parse.host.Base;
import cyy.controller.viewobject.UserVO;
import cyy.error.BusinessException;
import cyy.error.EmBusinessError;
import cyy.response.CommonReturnType;
import cyy.service.UserService;
import cyy.service.impl.UserServiceImpl;
import cyy.service.model.UserModel;
import cyy.validator.ValidatorImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller("user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", origins = "*")//跨域请求，若什么都不指定，对于ajax来说是无法共享的
public class UserController extends BaseController {


    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    //登录接口
    @RequestMapping(value = "/login", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType login(@RequestParam(name = "telphone") String telphone,
                                  @RequestParam(name = "password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        if (StringUtils.isEmpty(telphone) || StringUtils.isEmpty(password)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        //校验用户登录是否合法
        UserModel userModel = userService.validateLogin(telphone, this.EncodeByMd5(password));
        //将登录凭证加入到用胡登录成功的session内
        this.httpServletRequest.getSession().setAttribute("IS_LOGIN", true);
        this.httpServletRequest.getSession().setAttribute("LOGIN_USER", userModel);

        return CommonReturnType.creat(null);
    }

    //用户注册接口
    @RequestMapping(value = "/register", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType regist(@RequestParam(name = "telphone") String telphone,
                                   @RequestParam(name = "otpCode") String otpCode,
                                   @RequestParam(name = "name") String name,
                                   @RequestParam(name = "gender") Integer gender,
                                   @RequestParam(name = "age") Integer age,
                                   @RequestParam(name = "password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //验证手机号和对应的otpCode
        String inSessionOtpCode = (String) this.httpServletRequest.getSession().getAttribute(telphone);
        if (!StringUtils.equals(otpCode, inSessionOtpCode)) {
//            System.out.println(otpCode);
//            System.out.println(inSessionOtpCode);
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "短信验证码不符合");
        }
        //用户注册流程
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setAge(age);
        userModel.setTelphone(telphone);
        userModel.setGender(new Byte(String.valueOf(gender.intValue())));
        userModel.setRegisterMode("byphone");
        userModel.setEncrptPassword(this.EncodeByMd5(password));
        userService.register(userModel);
        return CommonReturnType.creat(null);
    }

    //加密
    public String EncodeByMd5(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        //确定一个计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //加密字符串
        String newstr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    //用户获取otp短信接口
    //consumes是每次执行消费一个CONTENT_TYPE_FORMED
    @RequestMapping(value = "/getotp", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name = "telphone") String telphone) {
        //按照一定规则生成otp验证码
        Random random = new Random();
        int randomInt = random.nextInt(99999);
        randomInt += 10000;
        String otpCode = String.valueOf(randomInt);

        //将验证码同对应用户的手机号关联
        //在企业中，这里是用redis来实现
        //暂时使用HttpSession
        httpServletRequest.getSession().setAttribute(telphone, otpCode);
        //将验证码通过短信发送给用户，省略
        //先用打印，企业用的是log4j
        System.out.println("telphoneNum:" + telphone + ",optCode:" + otpCode);
        return CommonReturnType.creat(null);
    }

    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        //调用
        UserModel userModelById = userService.getUserById(id);
        if (userModelById == null) {
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);

        }
        UserVO userVO = convertUserModel(userModelById);
        return CommonReturnType.creat(userVO);
    }

    //  将核心领域的模型对象转换为可供UI使用的viewobject
    private UserVO convertUserModel(UserModel userModel) {
        if (userModel == null) return null;
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }


}
