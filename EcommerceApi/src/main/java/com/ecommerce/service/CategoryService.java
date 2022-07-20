package com.ecommerce.service;

import com.ecommerce.dao.CategoryDao;
import com.ecommerce.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public List<Category> getAllCategories() {

		return categoryDao.getAllCategories();
	}

}
