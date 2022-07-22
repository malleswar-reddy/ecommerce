package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.ProductService;

@Controller
public class CategoryController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/category")
	public String categoryControl(@RequestParam("category_id") int category_id, ModelMap model) {
//		 int category_id = Integer.parseInt(request.getParameter("category_id"));

	       
	        List<Product> productList = productService.getAllCategoryProducts(category_id);
	       
	        List<Category> categoryList = categoryService.getAllCategories();

	       model.addAttribute("product_list", productList);
	       model.addAttribute("category_list", categoryList);
	       
		return "shop";
	}
	
	
}
