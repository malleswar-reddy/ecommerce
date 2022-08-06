package com.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;

@Controller
public class ProductDetailController {
	
	@Autowired
	private ProductService productService;

    @GetMapping("/product-detail")
    protected String productDetailPage(HttpServletRequest request,ModelMap model){
        
        boolean alert = request.getParameter("invalid-quantity") != null;
        // Get the id of selected product.
        int id = Integer.parseInt(request.getParameter("id"));

        // Get product from database with the given id.
        Product product = productService.getProduct(id);

        // Check number product available.
        String disabled = "";
        if (product.getAmount() <= 0) {
            disabled = "disabled";
        }

        // Get all products for feature section.
        List<Product> productList = productService.getAllProducts();

        // Set attribute active class for home in header.
        String active = "active";

        model.addAttribute("alert", alert);
        model.addAttribute("disabled", disabled);
        model.addAttribute("shop_active", active);
        model.addAttribute("product", product);
        model.addAttribute("product_list", productList);
        return "product-detail";
    }
    
   
}
