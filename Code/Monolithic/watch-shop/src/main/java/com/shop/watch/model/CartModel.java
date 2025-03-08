package com.shop.watch.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Cart")
public class CartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Integer cartId;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel product;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountModel account;
    @Column(name = "product_quantity")
    private Integer productQuantity;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}
