package com.shop.watch.service;

import com.shop.watch.model.ProductTypeModel;
import com.shop.watch.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    public List<ProductTypeModel> getAllProductType(){
        return productTypeRepository.findAll();
    }

    public ProductTypeModel getProductTypeById(Integer id){
        return productTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("ProductType not found"));
    }

    public ProductTypeModel createProductType(ProductTypeModel productTypeModel){
        return productTypeRepository.save(productTypeModel);
    }

    public ProductTypeModel updateProductType(Integer id, ProductTypeModel productTypeModel){
        ProductTypeModel productTypeUpdated = getProductTypeById(id);
        productTypeUpdated.setTypeName(productTypeModel.getTypeName());
        return productTypeRepository.save(productTypeUpdated);
    }

    public void deleteProductType(Integer id){
        productTypeRepository.deleteById(id);
    }
}
