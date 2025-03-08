package com.shop.watch.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Supplier")
@NoArgsConstructor
@AllArgsConstructor
public class SupplierModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Integer supplierId;
    @Column(name = "supplier_name")
    private String supllierName;

//    @OneToMany(mappedBy = "supplierEntity")
//    private Set<ProductModel> products;


    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupllierName() {
        return supllierName;
    }

    public void setSupllierName(String supllierName) {
        this.supllierName = supllierName;
    }
}
