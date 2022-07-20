package com.ecommerce.dao;


import com.ecommerce.model.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CategoryDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @PostConstruct
    public void setConnection() throws SQLException {
        connection = jdbcTemplate.getDataSource().getConnection();
    }

    // Method to set amount of products for category.
    private void queryCategoryProductAmount(Category category) {
        int productId = category.getId();
        String query = "SELECT COUNT(*) FROM product WHERE fk_category_id = " + productId + " AND product_is_deleted = false";
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //connection = jdbcTemplate.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category.setTotalCategoryProduct(resultSet.getInt(1));
            }
        } catch (SQLException e) {
        	log.error(e.getMessage());
            System.out.println("Get category products amount catch: ");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }



    // Method to get category by id.
    public Category getCategory(int categoryId) {
        Category category = new Category();
        String query = "SELECT * FROM category WHERE category_id = " + categoryId;
        try {
           // Class.forName("com.mysql.jdbc.Driver");
           // connection = jdbcTemplate.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category.setId(resultSet.getInt(1));
                category.setName(resultSet.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // Call method to set category amount for category.
        queryCategoryProductAmount(category);

        return category;
    }

    // Method to get all categories from database.
    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        String query = "SELECT * FROM category";
        try {
           // Class.forName("com.mysql.jdbc.Driver");
          //  connection = jdbcTemplate.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt(1));
                category.setName(resultSet.getString(2));
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Call method to set category amount for category.
        for (Category category : list) {
            queryCategoryProductAmount(category);
        }

        return list;
    }
}
