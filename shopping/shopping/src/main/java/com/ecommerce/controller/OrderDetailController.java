package com.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.model.CartProduct;
import com.ecommerce.service.OrderService;

@Controller
public class OrderDetailController {
	
	@Autowired
	private OrderService orderServicer;

    @GetMapping("/order-detail")
    public String orderDetailPage(HttpServletRequest request, ModelMap model){
        // Get order id from request.
        int orderId = Integer.parseInt(request.getParameter("order-id"));
        // Get order by id from database.
        List<CartProduct> list = orderServicer.getOrderDetailHistory(orderId);

        model.addAttribute("order_detail_list", list);
        // Get request dispatcher and render to order-detail page.
       return "order-detail";
    }    
    
}
