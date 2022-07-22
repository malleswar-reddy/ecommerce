package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.entity.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	public List<Product> getAllProducts() {
		
		return productDao.getAllProducts();
	}

	

	public List<Product> getAllCategoryProducts(int category_id) {
		
		return productDao.getAllCategoryProducts(category_id);
	}
	
	
}
