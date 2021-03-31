package cyy.service.impl;

import cyy.dao.OrderDOMapper;
import cyy.dao.SequenceDOMapper;
import cyy.dataobject.OrderDO;
import cyy.dataobject.SequenceDO;
import cyy.error.BusinessException;
import cyy.error.EmBusinessError;
import cyy.service.OrderService;
import cyy.service.model.ItemModel;
import cyy.service.model.OrderModel;
import cyy.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ItemServiceImpl itemService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private OrderDOMapper orderDOMapper;
    @Autowired
    private SequenceDOMapper sequenceDOMapper;

    @Override
    @Transactional
    public OrderModel creatOrder(Integer userId, Integer itemId, Integer promoId, Integer amount) throws BusinessException {

        //1.校验下单状态
        ItemModel itemModel = itemService.getItemById(itemId);
        if (itemModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "商品信息不存在");
        }
        UserModel userModel = userService.getUserById(userId);
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "用户信息不存在");
        }
        if (amount <= 0 || amount > 99) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "数量信息不正确");
        }
        //校验活动信息
        if (promoId != null) {
            //1.校验对应的活动是否存在这个适用商品
            if (promoId.intValue() != itemModel.getPromoModel().getId()) {
                throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "活动信息不正确");
            }
            //2.校验活动是否在进行中
            else if (itemModel.getPromoModel().getStatus().intValue() != 2) {
                throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "活动还未开始");
            }
        }

        //2.落单减库存
        boolean result = itemService.decreaseStock(itemId, amount);
        if (!result) {
            throw new BusinessException(EmBusinessError.STOCK_NOT_ENOUGH);
        }

        //3.订单入库

        OrderModel orderModel = new OrderModel();
        orderModel.setUserId(userId);
        orderModel.setItemId(itemId);
        orderModel.setAmount(amount);
        if (promoId != null) {
            orderModel.setItemPrice(itemModel.getPromoModel().getPromoItemPrice());
        } else {
            orderModel.setItemPrice(itemModel.getPrice());

        }
        //orderModel.setPromoId(promoId);
        orderModel.setOrderPrice(orderModel.getItemPrice().multiply(new BigDecimal(amount)));
        //生成交易订单号
        //使用自创的生成方法生成序列号
        orderModel.setId(generateOrderNo());
        OrderDO orderDO = convertFromOrderModel(orderModel);
        orderDOMapper.insertSelective(orderDO);
        //加上商品销量
        itemService.increaseSales(itemId, amount);
        // 4.返回前端

        return orderModel;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    String generateOrderNo() {
        //16位
        StringBuilder stringBuilder = new StringBuilder();
        //前八位时间信息
        LocalDateTime now = LocalDateTime.now();
        String nowDate = now.format(DateTimeFormatter.ISO_DATE).replace("-", "");
        stringBuilder.append(nowDate);
        //中间6位为自增序列
        //获取当前sequence
        int sequence = 0;
        SequenceDO sequenceDO = sequenceDOMapper.getSequenceByName("order_info");
        sequence = sequenceDO.getCurrentVale();
        //拿到sequnence后将其加上预设的步长
        sequenceDO.setCurrentVale(sequence + sequenceDO.getStep());
        sequenceDOMapper.updateByPrimaryKeySelective(sequenceDO);

        String sequenceStr = Integer.toString(sequence);
        //不足6位的用0补足
        for (int i = 0; i < 6 - sequenceStr.length(); i++) {
            stringBuilder.append('0');
        }
        stringBuilder.append(sequenceStr);
        //最后两位为分库分表位
        stringBuilder.append("00");//暂时写死
        return stringBuilder.toString();
    }

    private OrderDO convertFromOrderModel(OrderModel orderModel) {
        if (orderModel == null) {
            return null;
        }
        OrderDO orderDO = new OrderDO();
        BeanUtils.copyProperties(orderModel, orderDO);
        orderDO.setItemPrice(orderModel.getItemPrice().doubleValue());
        orderDO.setOrderPrice(orderModel.getOrderPrice().doubleValue());
        return orderDO;
    }


}
