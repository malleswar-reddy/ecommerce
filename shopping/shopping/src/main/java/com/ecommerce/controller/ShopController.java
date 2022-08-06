package com.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.ProductService;

@Controller
public class ShopController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
    CategoryService categoryService;

   @GetMapping("/shop")
    public String shopPage(HttpServletRequest request, ModelMap model){
        // Get page number from request.
        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }

        // Get 12 products from database to display on each page.
        List<Product> productList = productService.get12ProductsOfPage(Integer.parseInt(index));

        // Get all categories from database.
        List<Category> categoryList = categoryService.getAllCategories();

        // Get total products to count pages.
        int totalProduct = productService.getTotalNumberOfProducts();
        int totalPages = totalProduct / 12;
        if (totalProduct % 12 != 0) {
            totalPages++;
        }

        // Set attribute active class for home in header and page number.
        String active = "active";

       model.addAttribute("product_list", productList);
       model.addAttribute("category_list", categoryList);
       model.addAttribute("total_pages", totalPages);
       model.addAttribute("shop_active", active);
       model.addAttribute("page_active", index);
       return "shop";
    }
}
