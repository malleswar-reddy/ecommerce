package com.ecommerce.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private static Connection conn;

    private Database(){}

    public static Connection getConnection() {

        try {
            if(conn== null){
                synchronized (Database.class){
                    if(conn== null){
						Class.forName("com.mysql.cj.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp-servlet-ecommerce-website", "root", "root");
                    }
                }
            }
            return conn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Database().getConnection());
    }
}
