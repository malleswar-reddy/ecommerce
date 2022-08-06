package com.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.model.Account;
import com.ecommerce.model.CartProduct;
import com.ecommerce.model.Product;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.ProductService;
@Controller
public class OrderManagementController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
    private OrderService orderService;

    @GetMapping("/order-management")
   public String orderManagementPage(HttpServletRequest request,ModelMap model) {
        // Get account id from session.
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        int accountId = account.getId();

        // Get product list of seller.
        List<Product> productList = productService.getSellerProducts(accountId);
        List<CartProduct> cartProductList = null;
        for (Product product : productList) {
            if (cartProductList == null) {
                cartProductList = orderService.getSellerOrderDetail(product.getId());
            } else {
                cartProductList.addAll(orderService.getSellerOrderDetail(product.getId()));
            }
        }

        model.addAttribute("order_detail_list", cartProductList);
       
        model.addAttribute("order_management_active", "active");
      
        return "order-management";
    }
}
