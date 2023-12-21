package com.example.shopping.Shopping.App;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Table
@Entity
public class Product {

    @Id
    @SequenceGenerator(
            name = "sequence_name",
            sequenceName = "sequence_name",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String productName;
    private BigDecimal productPrice;
    private String productBrand;
    private String productDescription;

    public Product() {
    }

    public Product(Long id, String productName, BigDecimal productPrice, String productBrand, String productDescription) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productBrand = productBrand;
        this.productDescription = productDescription;
    }

    public Product(String productName, BigDecimal productPrice, String productBrand, String productDescription) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productBrand = productBrand;
        this.productDescription = productDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productBrand='" + productBrand + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
