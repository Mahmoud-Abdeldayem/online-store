package com.online_store.product_microservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Lob
    private byte[] image;
    private Integer productPrice;
    private String productQuantity;
    private String productName;
    private String productDescription;
    private String productCategory;
    private String gender;
}




