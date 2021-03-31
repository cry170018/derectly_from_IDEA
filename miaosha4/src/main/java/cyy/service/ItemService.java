package cyy.service;

import cyy.error.BusinessException;
import cyy.service.model.ItemModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ItemService {
    ItemModel creatItem(ItemModel itemModel) throws BusinessException;
    //shangPin列表浏览
    List<ItemModel> listItem();
    //商品详情浏览
    ItemModel getItemById(Integer id);

    //库存扣减
    /*
    * 商品id
    * 减多少件
    * */
    boolean decreaseStock(Integer itemId,Integer amount);

    /*
    *
    * 商品销量增加
    * */
    void increaseSales(Integer itemId,Integer amount);
}
