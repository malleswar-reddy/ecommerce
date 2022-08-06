package com.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.model.Account;
import com.ecommerce.model.Order;
import com.ecommerce.service.AccountService;
import com.ecommerce.service.OrderService;

@Controller
public class CheckoutController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private AccountService accountService;

    @PostMapping("/checkout")
    public String checkoutPage(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        // Get information from input field.
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        if (session.getAttribute("account") == null) {
            return"login";
        }
        else {
            double totalPrice = (double) session.getAttribute("total_price");
            Order order = (Order) session.getAttribute("order");
            Account account = (Account) session.getAttribute("account");

            // Insert information to account.
            int accountId = account.getId();
            accountService.updateProfileInformation(accountId, firstName, lastName, address, email, phone);
            // Insert order to database.
            orderService.createOrder(account.getId(), totalPrice, order.getCartProducts());
            session.removeAttribute("order");
            session.removeAttribute("total_price");

            return "thankyou.jsp";
          
        }
    }
}
