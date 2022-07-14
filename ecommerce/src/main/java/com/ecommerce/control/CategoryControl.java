package com.ecommerce.control;

import com.ecommerce.dao.CategoryDao;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Category;
import com.ecommerce.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryControl", value = "/category")
public class CategoryControl extends HttpServlet {
	
    // Call DAO class to access with database.
    ProductDao productDao = new ProductDao();
    CategoryDao categoryDao = new CategoryDao();

//    @Autowired
//    CategoryRepository categoryRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
//    	List<Category> categories = categoryRepository.findAll();
//    	System.out.println(categories.size());
    	
    	// Get the id of the selected category.
        int category_id = Integer.parseInt(request.getParameter("category_id"));

        // Get all products with the given category_id.
        List<Product> productList = productDao.getAllCategoryProducts(category_id);
        // Get all categories from database.
        List<Category> categoryList = categoryDao.getAllCategories();

        request.setAttribute("product_list", productList);
        request.setAttribute("category_list", categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shop.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
