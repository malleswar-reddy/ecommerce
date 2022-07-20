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


}
