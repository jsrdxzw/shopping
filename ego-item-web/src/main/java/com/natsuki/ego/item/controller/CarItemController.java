package com.natsuki.ego.item.controller;
import com.natsuki.ego.item.entity.CarItem;
import com.natsuki.ego.item.service.CarItemService;
import com.natsuki.ego.rpc.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-17
 * @Description:
 */
@Controller
@RequestMapping("/cart")
public class CarItemController {

    @Autowired
    private CarItemService carItemService;


    /**
     * 将商品添加到购物车请求
     * @return 添加成功页面
     */
    @RequestMapping("/add/{itemid}")
    public String cartAdd(@PathVariable Long itemid, HttpServletRequest request){
        TbUser user = (TbUser) request.getAttribute("user");
        //从拦截器中获得用户信息
        carItemService.addItemToCar(itemid,user.getId());
        return "cartSuccess";
    }

    @RequestMapping("/cart")
    public String loadCarItemList(HttpServletRequest request){
        TbUser user = (TbUser) request.getAttribute("user");
        Long id = user.getId();
        Map<Long, CarItem> carItemList = carItemService.getCarItemList(id);
        request.setAttribute("cartList",carItemList);
        return "cart";
    }

    @RequestMapping("/update/num/{itemid}/{num}")
    @ResponseBody
    public String carUpdate(@PathVariable Long itemid,@PathVariable Integer num,HttpServletRequest request){
        TbUser user = (TbUser) request.getAttribute("user");
        Long id = user.getId();
        return carItemService.updateCarItemNum(itemid,id,num);
    }

}
