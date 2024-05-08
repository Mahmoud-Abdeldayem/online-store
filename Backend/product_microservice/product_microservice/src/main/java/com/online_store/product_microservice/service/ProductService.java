package com.online_store.product_microservice.service;

import com.online_store.product_microservice.model.Products;
import com.online_store.product_microservice.repository.ProductRepo;
import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public ResponseEntity<List<Products>> showAllProducts() {
        try{
            return new ResponseEntity<>(productRepo.findAll(), HttpStatus.OK);
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }

    @Transactional
    public ResponseEntity<List<Products>> showByCategory(String productCategory){
        try{
            return new ResponseEntity<>(productRepo.findByproductCategory(productCategory),HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    @Transactional
    public ResponseEntity<List<Products>> showByGender(String gender){
        try{
            return new ResponseEntity<>(productRepo.findBygender(gender),HttpStatus.OK);
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    @Transactional
    public ResponseEntity<List<Products>> showByProductName(String productName){
        try{
            return new ResponseEntity<>(productRepo.findByproductName(productName),HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    @Transactional
    public ResponseEntity<List<Products>> showByProductPrice(int minPrice, int maxPrice){
        try{
            return new ResponseEntity<>(productRepo.findByproductPrice(minPrice, maxPrice),HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addProduct(Products product, MultipartFile imageFile) {
        try {
            if (imageFile != null && !imageFile.isEmpty()) {
                byte[] imageData = imageFile.getBytes();
                product.setImage(imageData);
            }
            productRepo.save(product);
            return ResponseEntity.ok("Product added successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add product. Please try again later.");
        }
    }

    public ResponseEntity<String> deleteProduct(Products product){
        productRepo.delete(product);
        try{
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
    }
}
