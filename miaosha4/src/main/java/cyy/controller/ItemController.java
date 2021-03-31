package cyy.controller;


import cyy.controller.viewobject.ItemVO;
import cyy.error.BusinessException;
import cyy.response.CommonReturnType;
import cyy.service.ItemService;
import cyy.service.impl.ItemServiceImpl;
import cyy.service.model.ItemModel;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Controller("/item")
@RequestMapping("/item")
@CrossOrigin(allowCredentials = "true", origins = "*" ,allowedHeaders = "true")//跨域请求，若什么都不指定，对于ajax来说是无法共享的
public class ItemController extends BaseController {

    @Autowired
    private ItemServiceImpl itemService;

    //商品页面浏览
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType listItem(){
        List<ItemModel> itemModelList = itemService.listItem();
        List<ItemVO> itemVOList = itemModelList.stream().map(itemModel -> {
            ItemVO itemVO = this.convertVOFromModel(itemModel);
            return itemVO;
        }).collect(Collectors.toList());
        return CommonReturnType.creat(itemVOList);
    }

    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getItem(@RequestParam(name = "id")Integer id){
        ItemModel itemModel = itemService.getItemById(id);
        ItemVO itemVO = convertVOFromModel(itemModel);
        return CommonReturnType.creat(itemVO);
    }


    @RequestMapping(value = "/creat", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType creatItem(@RequestParam(name = "title")String title,
                                        @RequestParam(name = "description")String description,
                                        @RequestParam(name = "price")BigDecimal price,
                                        @RequestParam(name = "stock")Integer stock,
                                        @RequestParam(name = "imgUrl")String imgUrl) throws BusinessException {
        //封装service请求用来创建商品
        ItemModel itemModel = new ItemModel();
        itemModel.setStock(stock);
        itemModel.setPrice(price);
        itemModel.setDescription(description);
        itemModel.setImgUrl(imgUrl);
        itemModel.setTitle(title);
        //把model转换成可供前端看的VO
        ItemModel itemModel1ForReturn = itemService.creatItem(itemModel);
        ItemVO itemVO = convertVOFromModel(itemModel1ForReturn);
        return CommonReturnType.creat(itemVO);
    }

    private ItemVO convertVOFromModel(ItemModel itemModel){
        if(itemModel==null){
            return null;
        }
        ItemVO itemVO = new ItemVO();
        BeanUtils.copyProperties(itemModel,itemVO);
        if(itemModel.getPromoModel()!=null){
         //有正在进行的秒杀活动
         itemVO.setPromoStatus(itemModel.getPromoModel().getStatus());
         itemVO.setPromoId(itemModel.getPromoModel().getId());
         itemVO.setStartDate(itemModel.getPromoModel().getStartDate().toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")));
         itemVO.setPromoPrice(itemModel.getPromoModel().getPromoItemPrice());

        }else{
            itemVO.setPromoStatus(0);
        }
        return itemVO;
    }
}
