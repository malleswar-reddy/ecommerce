package com.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class SearchController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService ;

    @GetMapping("/search")
    public String searchPage(HttpServletRequest request, ModelMap model) {
     
        String keyword = request.getParameter("keyword");

        // Get all products with the given keyword from database.
        List<Product> productList = productService.searchProduct(keyword);
        // Get all categories from database.
        List<Category> categoryList = categoryService.getAllCategories();

       model.addAttribute("product_list", productList);
       model.addAttribute("category_list", categoryList);
        return "shop";
    }
    
   @PostMapping("/1")
   public String searchProduct(HttpServletRequest request, HttpServletResponse response){
	   return "";
    }
}
