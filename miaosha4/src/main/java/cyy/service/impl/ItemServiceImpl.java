package cyy.service.impl;

import cyy.dao.ItemDOMapper;
import cyy.dao.ItemStockDOMapper;
import cyy.dataobject.ItemDO;
import cyy.dataobject.ItemStockDO;
import cyy.error.BusinessException;
import cyy.error.EmBusinessError;
import cyy.service.ItemService;
import cyy.service.PromoService;
import cyy.service.model.ItemModel;
import cyy.service.model.PromoModel;
import cyy.validator.ValidationResult;
import cyy.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl  implements ItemService{

    @Autowired
    private ValidatorImpl validator;
    @Autowired
    private ItemDOMapper itemDOMapper;
    @Autowired
    private ItemStockDOMapper itemStockDOMapper;
    @Autowired
    ItemServiceImpl itemService;
    @Autowired
    PromoServiceImpl promoService;
    @Override
    @Transactional
    public ItemModel creatItem(ItemModel itemModel) throws BusinessException {
        //校验入参
        ValidationResult result = validator.validate(itemModel);
        if(result.isHasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,result.getErrMsg());
        }
        //转化itemmodel  ->dataobject
        ItemDO itemDO = this.convertItemDOFromItemModel(itemModel);
        //写入数据库
        itemDOMapper.insertSelective(itemDO);
        itemModel.setId(itemDO.getId());
        ItemStockDO itemStockDO = this.convertItemStockFromItemModel(itemModel);
        itemStockDOMapper.insertSelective(itemStockDO);
        //返回创建完成的对象
        return this.getItemById(itemModel.getId());
    }


    private ItemDO convertItemDOFromItemModel(ItemModel itemModel){
        if(itemModel==null) {
            return  null;
        }
        ItemDO itemDO = new ItemDO();
        BeanUtils.copyProperties(itemModel,itemDO);
        itemDO.setPrice(itemModel.getPrice().doubleValue());
        return itemDO;
    }
    private ItemStockDO convertItemStockFromItemModel(ItemModel itemModel){
        if(itemModel==null){
            return null;
        }
        ItemStockDO itemStockDO = new ItemStockDO();
        itemStockDO.setItemId(itemModel.getId());
        itemStockDO.setStock(itemModel.getStock());
        return itemStockDO;

    }

    @Override
    public List<ItemModel> listItem() {
        List<ItemDO> itemDOList = itemDOMapper.listItem();
         List<ItemModel>itemModelList= itemDOList.stream().map(itemDO -> {
            ItemStockDO itemStockDO = itemStockDOMapper.selectByItemId(itemDO.getId());
            ItemModel itemModel = this.convertModelFromDataObject(itemDO,itemStockDO);
            return itemModel;
        }).collect(Collectors.toList());
        return itemModelList;
    }

    @Override
    public ItemModel getItemById(Integer id) {
        ItemDO itemDo = itemDOMapper.selectByPrimaryKey(id);
        if(itemDo==null){
            return null;
        }
        //操作获得库存数量
        ItemStockDO itemStockDO = itemStockDOMapper.selectByItemId(itemDo.getId());
        //将dataobject转化为model
        ItemModel itemModel = convertModelFromDataObject(itemDo,itemStockDO);

        //获取活动商品信息
        PromoModel promoModel = promoService.getPromoByItemId(itemModel.getId());
        if(promoModel!=null&&promoModel.getStatus()!=3){
            itemModel.setPromoModel(promoModel);
        }
        return itemModel;
    }

    @Override
    @Transactional
    public boolean decreaseStock(Integer itemId, Integer amount) {
        int affectedRow = itemStockDOMapper.decreaseStock(itemId, amount);
        return affectedRow>0;
    }

    @Override
    @Transactional
    public void increaseSales(Integer itemId, Integer amount) {
         itemDOMapper.increaseSales(itemId, amount);
    }

    private ItemModel convertModelFromDataObject(ItemDO itemDO,ItemStockDO itemStockDO){
        ItemModel itemModel = new ItemModel();
        BeanUtils.copyProperties(itemDO,itemModel);
        itemModel.setPrice(new BigDecimal(itemDO.getPrice()));
        itemModel.setStock(itemStockDO.getStock());
        return  itemModel;
    }
}
