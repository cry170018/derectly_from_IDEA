package cyy.controller;

import cyy.error.BusinessException;
import cyy.error.EmBusinessError;
import cyy.response.CommonReturnType;
import cyy.service.impl.OrderServiceImpl;
import cyy.service.model.OrderModel;
import cyy.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller("/order")
@RequestMapping("/order")
@CrossOrigin(allowCredentials = "true", origins = "*" ,allowedHeaders = "true")//跨域请求，若什么都不指定，对于ajax来说是无法共享的
public class OrderController  extends  BaseController{

    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    //封装下单请求

    @RequestMapping(value = "/creatorder",method = {RequestMethod.POST} ,consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType creatOrder(@RequestParam(name = "itemId")Integer itemId,
                                        @RequestParam(name = "amount")Integer amount,
                                       @RequestParam(name = "promoId",required = false)Integer promoId) /*不传的话就是平销*/throws BusinessException {
        Boolean isLogin = (Boolean)httpServletRequest.getSession().getAttribute("IS_LOGIN");
        if(isLogin==null||!isLogin.booleanValue()){
        throw  new BusinessException(EmBusinessError.USER_NOT_LOGIN,"用户还未登录，不能下单");
        }
        //获取用户的登录信息
        UserModel userModel = (UserModel) httpServletRequest.getSession().getAttribute("LOGIN_USER");
        OrderModel orderModel = orderService.creatOrder(userModel.getId(), itemId,promoId, amount);
        System.out.println(orderModel.toString());
        return CommonReturnType.creat(orderModel);
    }

}
