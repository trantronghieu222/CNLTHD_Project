package com.shop.watch.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Product")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_inventory")
    private int productInventory;

    @Column(name = "product_warranty")
    private Date productWarranty;

    @Column(name = "product_image")
    private String productImage;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierModel supplierEntity;

    @Column(name = "product_saleprice")
    private int productSaleprice;

    @Column(name = "product_inprice")
    private int productInprice;

    @Column(name = "product_description")
    private String productDescription;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ProductTypeModel typeId;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<CartModel> carts;

    @OneToMany(mappedBy = "product_order")
    private Set<OrderDetailModel> orders;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(int productInventory) {
        this.productInventory = productInventory;
    }

    public Date getProductWarranty() {
        return productWarranty;
    }

    public void setProductWarranty(Date productWarranty) {
        this.productWarranty = productWarranty;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public SupplierModel getSupplierEntity() {
        return supplierEntity;
    }

    public void setSupplierEntity(SupplierModel supplierEntity) {
        this.supplierEntity = supplierEntity;
    }

    public int getProductSaleprice() {
        return productSaleprice;
    }

    public void setProductSaleprice(int productSaleprice) {
        this.productSaleprice = productSaleprice;
    }

    public int getProductInprice() {
        return productInprice;
    }

    public void setProductInprice(int productInprice) {
        this.productInprice = productInprice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public ProductTypeModel getTypeId() {
        return typeId;
    }

    public void setTypeId(ProductTypeModel typeId) {
        this.typeId = typeId;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Set<CartModel> getCarts() {
        return carts;
    }

    public void setCarts(Set<CartModel> carts) {
        this.carts = carts;
    }

    public Set<OrderDetailModel> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderDetailModel> orders) {
        this.orders = orders;
    }
}
