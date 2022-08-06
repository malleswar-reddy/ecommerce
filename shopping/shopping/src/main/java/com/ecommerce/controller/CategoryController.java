package com.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.ProductService;

@Controller
public class CategoryController {
	
	@Autowired
	 private ProductService productService;
	@Autowired
	 private CategoryService categoryService;

	@GetMapping("/category")
	public String categoryPage(HttpServletRequest request,ModelMap model){
	    
	        int category_id = Integer.parseInt(request.getParameter("category_id"));

	        // Get all products with the given category_id.
	        List<Product> productList = productService.getAllCategoryProducts(category_id);
	        // Get all categories from database.
	        List<Category> categoryList = categoryService.getAllCategories();

	        request.setAttribute("product_list", productList);
	        request.setAttribute("category_list", categoryList);
	       return "shop";
	    }
	 @PostMapping("/")
	    public String categoryItem() {
		 return "shop";
	 }
}
