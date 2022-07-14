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
//@Table(name = "account")
//public class Account implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @Column(name = "account_id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer accountId;
//
//    @Column(name = "account_name")
//    private String accountName;
//
//    @Column(name = "account_password")
//    private String accountPassword;
//
//    @Column(name = "account_is_seller")
//    private Integer accountIsSeller;
//
//    @Column(name = "account_is_admin")
//    private Integer accountIsAdmin;
//
//    @Column(name = "account_address")
//    private String accountAddress;
//
//    @Column(name = "account_first_name")
//    private String accountFirstName;
//
//    @Column(name = "account_last_name")
//    private String accountLastName;
//
//    @Column(name = "account_email")
//    private String accountEmail;
//
//    @Column(name = "account_phone")
//    private String accountPhone;
//
//    @Column(name = "account_image")
//    private byte[] accountImage;
//
//}
