package com.online_store.product_microservice.repository;

import com.online_store.product_microservice.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Products,Integer> {

    List<Products> findByproductCategory(String productCategory);

    List<Products> findByproductName(String productName);

    List<Products> findBygender(String gender);

    @Query("SELECT p FROM Products p WHERE p.productPrice BETWEEN :minPrice AND :maxPrice")
    List<Products> findByproductPrice(int minPrice,int maxPrice);
}
