package com.ecommerce.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.model.Account;
import com.ecommerce.service.ProductService;

@Controller
public class AddProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add-product")
    public String addProductControllerPage(HttpServletRequest request, ModelMap model) {
        // Get product information from request.
        String productName = request.getParameter("product-name");
        double productPrice = Double.parseDouble((request.getParameter("product-price")));
        String productDescription = request.getParameter("product-description");
        int productCategory = Integer.parseInt(request.getParameter("product-category"));
        int productAmount = Integer.parseInt(request.getParameter("product-amount"));

        // Get upload image.
        Part part = null;
		try {
			part = request.getPart("product-image");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        InputStream inputStream = null;
		try {
			inputStream = part.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Get the seller id for product.
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        int sellerId = account.getId();

        // Add product to database.
        
        productService.addProduct(productName, inputStream, productPrice, productDescription, productCategory, sellerId, productAmount);
       return "product-management";
    }
}
