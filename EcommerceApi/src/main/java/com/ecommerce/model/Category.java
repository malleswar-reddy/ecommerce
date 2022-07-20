package com.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Category implements java.io.Serializable {
  private static final long serialVersionUID = 1L;
 
  private int id;

  private String name;

  private int totalCategoryProduct;

  
}
