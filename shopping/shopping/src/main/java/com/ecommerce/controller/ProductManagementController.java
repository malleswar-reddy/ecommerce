package com.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.model.Account;
import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.ProductService;

@Controller
public class ProductManagementController {
	
	@Autowired
    private ProductService productService;
	@Autowired
    private CategoryService categoryService;
	
    @GetMapping("/product-management")
    public String productManagementPage(HttpServletRequest request,ModelMap model) {
        // Get the seller id from session.
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        int sellerId = account.getId();
        // Get products of seller from database.
        List<Product> productList = productService.getSellerProducts(sellerId);
        // Get all category for category selection.
        List<Category> categoryList = categoryService.getAllCategories();

        model.addAttribute("category_list", categoryList);
        model.addAttribute("product_list", productList);
        // Set attribute active status for product management tab in header.
        model.addAttribute("product_management_active", "active");
        // Get request dispatcher and render to product-management page.
        return "product-management";
    }
}
