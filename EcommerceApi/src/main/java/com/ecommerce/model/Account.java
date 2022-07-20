package com.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Account {
    private int id;
    private String username;
    private String password;
    private int isSeller;
    private int isAdmin;
    private String address;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    private byte[] image;
    private String base64Image;


}
