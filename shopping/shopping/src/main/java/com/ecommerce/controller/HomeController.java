package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/")
	public String homeControl(ModelMap model) {
		List<Product> productList = productService.getAllProducts();
		List<Category> categoryList = categoryService.getAllCategories();

		model.addAttribute("product_list", productList);
		model.addAttribute("category_list", categoryList);
		model.addAttribute("home_active", "active");
		return "index";
	}

}
