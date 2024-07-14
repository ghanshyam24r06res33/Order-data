package com.gstech.Order.theta.service;

import com.gstech.Order.theta.account.model.db.mysql.Category;
import com.gstech.Order.theta.account.model.db.mysql.Order;
import com.gstech.Order.theta.repository.jpa.CategoryRepository;
import com.gstech.Order.theta.repository.jpa.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getAllOrders() {

        System.out.println("return all the oder list:");
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Long id, Order orderDetails) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            Order existingOrder = order.get();
            existingOrder.setProduct(orderDetails.getProduct());
            existingOrder.setQuantity(orderDetails.getQuantity());
            existingOrder.setPrice(orderDetails.getPrice());
            existingOrder.setCategory(orderDetails.getCategory());
            return orderRepository.save(existingOrder);
        } else {
            return null;
        }
    }

    @Override
    public void deleteOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        order.ifPresent(orderRepository::delete);
        System.out.println("branch test");
    }

    @Override
    public Order patchOrder(Long id, Order orderDetails) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            Order existingOrder = order.get();
            if (orderDetails.getProduct() != null) {
                existingOrder.setProduct(orderDetails.getProduct());
            }
            if (orderDetails.getQuantity() != 0) {
                existingOrder.setQuantity(orderDetails.getQuantity());
            }
            if (orderDetails.getPrice() != 0.0) {
                existingOrder.setPrice(orderDetails.getPrice());
            }
            if (orderDetails.getCategory() != null) {
                existingOrder.setCategory(orderDetails.getCategory());
            }
            return orderRepository.save(existingOrder);
        } else {
            return null;
        }
    }

    // Category methods
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
