package com.natsuki.ego.order.controller;

import com.natsuki.ego.order.entity.CarItem;
import com.natsuki.ego.order.service.OrderService;
import com.natsuki.ego.rpc.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-18
 * @Description:
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/cart")
    public String orderCart(HttpServletRequest request){
        TbUser user = (TbUser) request.getAttribute("user");
        Long id = user.getId();
        Map<Long, CarItem> carItemMap = orderService.getCarItemMap(id);
        request.setAttribute("carMap",carItemMap);
        return "ordercart";
    }

}
