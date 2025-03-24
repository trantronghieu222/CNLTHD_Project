package com.shop.watch.controller;

import com.shop.watch.model.ProductTypeModel;
import com.shop.watch.service.ProductTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/ProductType")
@Tag(name = "ProductType")
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping
    public ResponseEntity<List<ProductTypeModel>> getAllProductType(){
        return ResponseEntity.ok(productTypeService.getAllProductType());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductTypeModel> getProductTypeById(@RequestParam Integer id){
        ProductTypeModel productTypeModel = productTypeService.getProductTypeById(id);
        return ResponseEntity.ok(productTypeModel);
    }

    @PostMapping
    public ResponseEntity<ProductTypeModel> createProductType(@RequestBody ProductTypeModel productTypeModel){
        ProductTypeModel createdProduct = productTypeService.createProductType(productTypeModel);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductTypeModel> updateProductType(@RequestParam Integer id, @RequestBody ProductTypeModel productTypeModel){
        ProductTypeModel productTypeUpdated = productTypeService.updateProductType(id, productTypeModel);
        return ResponseEntity.ok(productTypeUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductType(@RequestParam Integer id){
        productTypeService.deleteProductType(id);
        return ResponseEntity.noContent().build();
    }
}
