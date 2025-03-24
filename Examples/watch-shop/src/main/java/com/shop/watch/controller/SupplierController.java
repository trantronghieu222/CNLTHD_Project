package com.shop.watch.controller;

import com.shop.watch.model.SupplierModel;
import com.shop.watch.service.SupplierService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/Supplier")
@Tag(name = "Supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<SupplierModel>> getAllSupplier(){
        return ResponseEntity.ok(supplierService.getAllSupplier());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierModel> getSupplierById(@RequestParam Integer id){
        return ResponseEntity.ok(supplierService.getSupplierById(id));
    }

    @PostMapping
    public ResponseEntity<SupplierModel> createSupplier(@RequestBody SupplierModel supplierModel){
        SupplierModel createSupplier = supplierService.createSupplier(supplierModel);
        return ResponseEntity.ok(createSupplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierModel> updateSupplier(@RequestParam Integer id, @RequestBody SupplierModel supplierModel){
        SupplierModel updatedSupplier = supplierService.updateSupplier(id, supplierModel);
        return ResponseEntity.ok(supplierModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@RequestParam Integer id){
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}
