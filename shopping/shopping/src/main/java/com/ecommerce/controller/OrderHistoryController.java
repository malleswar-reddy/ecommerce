package com.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.model.Account;
import com.ecommerce.model.Order;
import com.ecommerce.service.OrderService;

@Controller
public class OrderHistoryController {
	
	@Autowired
	private OrderService orderService ;

    @GetMapping("/order-history")
    public String orderHistoryPage(HttpServletRequest request, ModelMap model){
        // Get account from session.
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        // Get order history of account from database.
        List<Order> orderList = orderService.getOrderHistory(account.getId());

        model.addAttribute("order_list", orderList);
      
       model.addAttribute("order_history_active", "active");
        
        return "order-history";
    }
}
