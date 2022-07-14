//package com.ecommerce.model;
//
//import lombok.Data;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.io.Serializable;
//
//@Data
//@Entity
//@Table(name = "product")
//public class Product implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @Column(name = "product_id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer productId;
//
//    @Column(name = "product_name")
//    private String productName;
//
//    @Column(name = "product_price")
//    private Float productPrice;
//
//    @Column(name = "product_description")
//    private String productDescription;
//
//    @Column(name = "fk_category_id")
//    private Integer fkCategoryId;
//
//    @Column(name = "fk_account_id")
//    private Integer fkAccountId;
//
//    @Column(name = "product_is_deleted")
//    private Boolean productIsDeleted;
//
//    @Column(name = "product_amount")
//    private Integer productAmount;
//
//    @Column(name = "product_image")
//    private byte[] productImage;
//
//}
