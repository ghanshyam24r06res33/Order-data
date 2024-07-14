package com.gstech.Order.theta.service;



import com.gstech.Order.theta.account.model.db.mysql.Category;
import com.gstech.Order.theta.account.model.db.mysql.Order;

import java.util.List;
import java.util.Optional;


public interface OrderService {
    Order createOrder(Order order);
    Optional<Order> getOrderById(Long id);
    List<Order> getAllOrders();
    Order updateOrder(Long id, Order orderDetails);
    void deleteOrder(Long id);
    Order patchOrder(Long id, Order orderDetails);

    // Category methods
    Category createCategory(Category category);
    List<Category> getAllCategories();
}
