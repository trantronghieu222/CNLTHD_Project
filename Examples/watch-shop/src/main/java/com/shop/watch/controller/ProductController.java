package com.shop.watch.controller;

import com.shop.watch.dto.response.ProductResponse;
import com.shop.watch.dto.request.ProductCreate;
import com.shop.watch.model.ProductModel;
import com.shop.watch.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Api/Product")
@Tag(name = "Product")
public class ProductController {
    @Autowired
    private ProductService productService;

    private ProductResponse convertToDto(ProductModel productModel) {
        ProductResponse response = new ProductResponse();
        response.setProductId(productModel.getProductId());
        response.setProductName(productModel.getProductName());
        response.setProductInventory(productModel.getProductInventory());
        response.setProductWarranty(productModel.getProductWarranty());
        response.setProductImage(productModel.getProductImage());
        response.setProductSaleprice(productModel.getProductSaleprice());
        response.setProductInprice(productModel.getProductInprice());
        response.setProductDescription(productModel.getProductDescription());
        response.setDeleted(productModel.getDeleted());
        return response;
    }

    // Get ALl
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProduct(){
        List<ProductModel> products = productService.getAllProduct();
        List<ProductResponse> productResponses = products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productResponses);
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@RequestParam Integer id){
        ProductModel product = productService.getProductById(id);
        if(product != null) {
            ProductResponse productResponse = convertToDto(product);
            return ResponseEntity.ok(productResponse);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
    }

    // Post
    @PostMapping
    public ResponseEntity<ProductModel> createProduct(@RequestBody ProductCreate request){
        ProductModel productModel = productService.createProduct(request);
        return ResponseEntity.ok(productModel);
    }

    // Put
    @PutMapping
    public ResponseEntity<ProductModel> updateProduct(@RequestParam Integer id, @RequestBody ProductCreate productCreate){
        ProductModel productModel = productService.updateProduct(id, productCreate);
        return ResponseEntity.ok(productModel);
    }

    // Delete
    @DeleteMapping
    public ResponseEntity<String> deleteProduct(@RequestParam Integer id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
