package cyy.service;

import cyy.service.model.PromoModel;

public interface PromoService {
    //根据商品id获取即将进行的或正在进行的活动
    PromoModel getPromoByItemId(Integer itemId);
}
