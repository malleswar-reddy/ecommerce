//package com.ecommerce.controller;
//
//import com.ecommerce.model.Category;
//import com.ecommerce.repository.CategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.List;
//
//@Controller
//public class CategoryController {
//	
//	
//	  @Autowired 
//	  private CategoryRepository categoryRepository;
//	 
//
////    @GetMapping("/AllCategorys")
//    @RequestMapping(value = "/AllCategorys", method = RequestMethod.GET)
//    public List<Category> getAllCategorys(){
//        return  null;//categoryRepository.findAll();
//    }
//    
//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public String getTest(){
//    	List<Category>  categories =categoryRepository.findAll();
//    	System.out.println(categories.size());
//        return  "Working";//categoryRepository.findAll();
//    }
//}
