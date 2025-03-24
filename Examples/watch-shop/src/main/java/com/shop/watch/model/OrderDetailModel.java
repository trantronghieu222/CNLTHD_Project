package com.shop.watch.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Order_details")
public class OrderDetailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer OrderDetail_id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderModel orders;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel product_order;
    @Column(name = "product_quantity")
    private Integer product_quantity;

    public Integer getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(Integer product_quantity) {
        this.product_quantity = product_quantity;
    }

    public ProductModel getProduct_order() {
        return product_order;
    }

    public void setProduct_order(ProductModel product_order) {
        this.product_order = product_order;
    }

    public OrderModel getOrders() {
        return orders;
    }

    public void setOrders(OrderModel orders) {
        this.orders = orders;
    }

    public Integer getOrderDetail_id() {
        return OrderDetail_id;
    }

    public void setOrderDetail_id(Integer orderDetail_id) {
        OrderDetail_id = orderDetail_id;
    }
}
