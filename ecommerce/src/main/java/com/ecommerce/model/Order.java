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
//import java.time.LocalDateTime;
//
//@Data
//@Entity
//@Table(name = "order")
//public class Order implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @Column(name = "order_id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer orderId;
//
//    @Column(name = "fk_account_id")
//    private Integer fkAccountId;
//
//    @Column(name = "order_total")
//    private Float orderTotal;
//
//    @Column(name = "order_date_create", nullable = false)
//    private LocalDateTime orderDateCreate;
//
//}
