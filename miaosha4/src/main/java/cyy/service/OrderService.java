package cyy.service;

import cyy.error.BusinessException;
import cyy.service.model.OrderModel;

public interface OrderService {

    OrderModel creatOrder(Integer userId,Integer itemId,Integer promoId,Integer amount) throws BusinessException;
}
