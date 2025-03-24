package com.shop.watch.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Orders")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @OneToMany(mappedBy = "orders")
    private Set<OrderDetailModel> listOrderDetails;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private AccountModel customerId;
    @Column(name = "order_money")
    private Integer orderMoney;
    @Column(name = "order_date")
    private String orderDate;

    // getter & setter
    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Integer orderMoney) {
        this.orderMoney = orderMoney;
    }

    public AccountModel getCustomerId() {
        return customerId;
    }

    public void setCustomerId(AccountModel customerId) {
        this.customerId = customerId;
    }

    public Set<OrderDetailModel> getListOrderDetails() {
        return listOrderDetails;
    }

    public void setListOrderDetails(Set<OrderDetailModel> listOrderDetails) {
        this.listOrderDetails = listOrderDetails;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
