package com.ecommerce.controller;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ecommerce")
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/home")
    public Map homeControl() {
        Map<String,Object> hashMap = new HashMap<>();
        List<Product> productList = productService.getAllProducts();
        List<Category> categoryList = categoryService.getAllCategories();

        hashMap.put("product_list", productList);
        hashMap.put("category_list", categoryList);
        hashMap.put("home_active", "active");
        return hashMap;
    }

}
