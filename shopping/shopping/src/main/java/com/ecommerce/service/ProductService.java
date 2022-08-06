package com.ecommerce.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	public List<Product> getAllProducts() {
		
		return productDao.getAllProducts();
	}

	public List<Product> get12ProductsOfPage(int parseInt) {
		
		return productDao.get12ProductsOfPage(parseInt);
	}

	public int getTotalNumberOfProducts() {
		
		return productDao.getTotalNumberOfProducts();
	}

	public Product getProduct(int productId) {
		
		return productDao.getProduct(productId);
	}

	public List<Product> getAllCategoryProducts(int category_id) {
		List<Product> allCategoryProducts = productDao.getAllCategoryProducts(category_id);
		return allCategoryProducts;
	}

	public List<Product> getSellerProducts(int sellerId) {
		
		return productDao.getSellerProducts(sellerId);
	}

	public List<Product> searchProduct(String keyword) {
		
		return productDao.searchProduct(keyword);
	}

	public void removeProduct(Product product) {
		productDao.removeProduct(product);
	}

	public void addProduct(String productName, InputStream inputStream, double productPrice, String productDescription,
			int productCategory, int sellerId, int productAmount) {
		productDao.addProduct(productName, inputStream, productPrice, productDescription, productCategory, sellerId, productAmount);
		
	}
	
	
}
