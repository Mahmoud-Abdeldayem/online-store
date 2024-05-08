package com.online_store.product_microservice.controller;

import com.online_store.product_microservice.model.Products;
import com.online_store.product_microservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("Products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("ShowAll")
    public ResponseEntity<List<Products>> showAllProducts(){
       return productService.showAllProducts();
   }

   @GetMapping("Category/{productCategory}")
   public ResponseEntity<List<Products>> showByCategory(@PathVariable String productCategory){
        return productService.showByCategory(productCategory);
   }

   @GetMapping("ProductName/{productName}")
   public ResponseEntity<List<Products>> showByProductName(@PathVariable String productName){
        return productService.showByProductName(productName);
   }


    @GetMapping("ProductPrice/{minPrice}/{maxPrice}")
    public ResponseEntity<List<Products>> showByProductName(@PathVariable int minPrice, @PathVariable int maxPrice){
        return productService.showByProductPrice(minPrice,maxPrice);
    }
    @GetMapping("Gender/{gender}")
    public ResponseEntity<List<Products>> showByGender(@PathVariable String gender){
        return productService.showByGender(gender);
    }


    @PostMapping("/ADD")
    public ResponseEntity<String> addProduct(@ModelAttribute Products product, @RequestParam("imageFile") MultipartFile imageFile) {
        return productService.addProduct(product, imageFile);
    }

   @PutMapping("Update")
    public ResponseEntity<String> updateProduct(@ModelAttribute Products product, @RequestParam("imageFile") MultipartFile imageFile){
        return productService.addProduct(product, imageFile);
   }

   @DeleteMapping("Delete")
    public ResponseEntity<String> deleteProduct(@ModelAttribute Products product){
        return productService.deleteProduct(product);
   }


}
