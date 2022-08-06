package com.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;

@Controller
public class RemoveProductController {
	
	@Autowired
	private ProductService productService;
	
	
	 @GetMapping("/remove-product")
	    public String removeProductPage(HttpServletRequest request){
	        // Get the id of the product that need to remove from request.
	        int productId = Integer.parseInt(request.getParameter("product-id"));
	        // Remove product from database.
	     
	        Product product = productService.getProduct(productId);
	        productService.removeProduct(product);

	        return "/product-management";
	    }

	 @PostMapping("/2")
	   public String removeProduct(HttpServletRequest request, HttpServletResponse response){
		   return "";
	    }
}
