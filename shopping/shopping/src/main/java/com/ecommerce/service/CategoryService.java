package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.CategoryDao;
import com.ecommerce.model.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public List<Category> getAllCategories() {

		return categoryDao.getAllCategories();
	}

}
