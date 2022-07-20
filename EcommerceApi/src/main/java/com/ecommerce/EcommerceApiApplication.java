package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ecommerce"})
public class EcommerceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApiApplication.class, args);
    }

  /*  @Bean
    public CategoryDao categorybean() {
        return new CategoryDao();
    }*/


  /*  @Bean
    public JdbcTemplate jdbcTemplate() {
        try {
            // extract this 4 parameters using your own logic
            final String driverClassName = "com.mysql.cj.jdbc.Driver";
            final String jdbcUrl = "jdbc:mysql://localhost:3306/jsp-servlet-ecommerce-website";
            final String username = "root";
            final String password = "root";
            // Build dataSource manually:
            final Class<?> driverClass = ClassUtils.resolveClassName(driverClassName, this.getClass().getClassLoader());
            final Driver driver = (Driver) ClassUtils.getConstructorIfAvailable(driverClass).newInstance();
            final DataSource dataSource = new SimpleDriverDataSource(driver, jdbcUrl, username, password);
            // or using DataSourceBuilder:
            //final DataSource dataSource =
            // DataSourceBuilder.create().driverClassName(driverClassName).url(jdbcUrl).username(username).password(password).build();
            // and make the jdbcTemplate
            return new JdbcTemplate(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
