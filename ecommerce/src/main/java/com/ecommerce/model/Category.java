package com.ecommerce.model;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;


/*@Table(name = "category")
@Entity
@Data*/
public class Category implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
   /* @Id
    @Column(name = "category_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "category_number_product")
    private Integer categoryNumberProduct;
    */

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "category_id")
    private int id;

//    @Column(name = "category_name")
    private String name;

//    @Column(name = "category_number_product")
    private int totalCategoryProduct;

    public Category() {}

    public Category(int id, String name, int totalCategoryProduct) {
        this.id = id;
        this.name = name;
        this.totalCategoryProduct = totalCategoryProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCategoryProduct() {
        return totalCategoryProduct;
    }

    public void setTotalCategoryProduct(int totalCategoryProduct) {
        this.totalCategoryProduct = totalCategoryProduct;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalCategoryProduct=" + totalCategoryProduct +
                '}';
    }
}
