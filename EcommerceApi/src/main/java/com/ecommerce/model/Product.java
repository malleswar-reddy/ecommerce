package com.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private int id;
    private String name;
    private double price;
    private String description;
    private Category category;
    private Account account;
    private boolean isDeleted;
    private int amount;

    private byte[] image;
    private String base64Image;

    public Product(int id, String name, String base64Image, double price, String description, Category category, Account account,
                   boolean isDelete, int amount) {
        this.id =id;
        this.name =name;
        this.base64Image =base64Image;
        this.price = price;
        this.description =description;
        this.category =category;
        this.account =account;
        this.isDeleted =isDelete;
        this.amount =amount;

    }
}
