package com.shop.watch.service;

import com.shop.watch.dto.request.ProductCreate;
import com.shop.watch.model.ProductModel;
import com.shop.watch.model.ProductTypeModel;
import com.shop.watch.model.SupplierModel;
import com.shop.watch.repository.ProductRepository;
import com.shop.watch.repository.ProductTypeRepository;
import com.shop.watch.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    public List<ProductModel> getAllProduct(){
        return productRepository.findAll();
    }

    public ProductModel getProductById(Integer id){
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public ProductModel createProduct (ProductCreate productCreate){
        ProductModel productModel = new ProductModel();
        productModel.setProductName(productCreate.getProductName());
        productModel.setProductInventory(productCreate.getProductInventory());
        productModel.setProductWarranty(productCreate.getProductWarranty());
        productModel.setProductImage(productCreate.getProductImage());
        productModel.setProductSaleprice(productCreate.getProductSaleprice());
        productModel.setProductInprice(productCreate.getProductInprice());
        productModel.setProductDescription(productCreate.getProductDescription());
//        productModel.setDeleted(productCreate.getDeleted());

        // Load SupplierModel từ database
        Optional<SupplierModel> supplierOptional = supplierRepository.findById(productCreate.getSupplierId());
        if (supplierOptional.isPresent()) {
            productModel.setSupplierEntity(supplierOptional.get());
        } else {
            throw new RuntimeException("Supplier not found with id: " + productCreate.getSupplierId());
        }

        // Load ProductTypeModel từ database
        Optional<ProductTypeModel> productTypeOptional = productTypeRepository.findById(productCreate.getTypeId());
        if (productTypeOptional.isPresent()) {
            productModel.setTypeId(productTypeOptional.get());
        } else {
            throw new RuntimeException("Product type not found with id: " + productCreate.getTypeId());
        }

        return productRepository.save(productModel);
    }

    public ProductModel updateProduct (Integer id, ProductCreate productCreate){
        ProductModel productModel = getProductById(id);

        productModel.setProductName(productCreate.getProductName());
        productModel.setProductInventory(productCreate.getProductInventory());
        productModel.setProductWarranty(productCreate.getProductWarranty());
        productModel.setProductImage(productCreate.getProductImage());
        productModel.setProductSaleprice(productCreate.getProductSaleprice());
        productModel.setProductInprice(productCreate.getProductInprice());
        productModel.setProductDescription(productCreate.getProductDescription());
//        productModel.setDeleted(productCreate.getDeleted());

        // Load SupplierModel từ database
        Optional<SupplierModel> supplierOptional = supplierRepository.findById(productCreate.getSupplierId());
        if (supplierOptional.isPresent()) {
            productModel.setSupplierEntity(supplierOptional.get());
        } else {
            throw new RuntimeException("Supplier not found with id: " + productCreate.getSupplierId());
        }

        // Load ProductTypeModel từ database
        Optional<ProductTypeModel> productTypeOptional = productTypeRepository.findById(productCreate.getTypeId());
        if (productTypeOptional.isPresent()) {
            productModel.setTypeId(productTypeOptional.get());
        } else {
            throw new RuntimeException("Product type not found with id: " + productCreate.getTypeId());
        }

        return productRepository.save(productModel);
    }

    public ProductModel deleteProduct(Integer id){
        ProductModel productModel = getProductById(id);
        productModel.setDeleted(true);
        return productRepository.save(productModel);
    }
}
