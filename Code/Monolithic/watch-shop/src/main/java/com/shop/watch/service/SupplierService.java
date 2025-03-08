package com.shop.watch.service;

import com.shop.watch.model.SupplierModel;
import com.shop.watch.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public List<SupplierModel> getAllSupplier(){
        return supplierRepository.findAll();
    }

    public SupplierModel getSupplierById(Integer id){
        return supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    public SupplierModel createSupplier(SupplierModel supplierModel){
        return supplierRepository.save(supplierModel);
    }

    public SupplierModel updateSupplier(Integer id, SupplierModel supplierModel){
        SupplierModel updatedSupplier = getSupplierById(id);
        updatedSupplier.setSupllierName(supplierModel.getSupllierName());
        return supplierRepository.save(updatedSupplier);
    }

    public void deleteSupplier(Integer id){
        supplierRepository.deleteById(id);
    }
}
