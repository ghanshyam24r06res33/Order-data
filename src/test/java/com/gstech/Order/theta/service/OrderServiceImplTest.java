package com.gstech.Order.theta.service;


import com.gstech.Order.theta.account.model.db.mysql.Category;
import com.gstech.Order.theta.account.model.db.mysql.Order;
import com.gstech.Order.theta.repository.jpa.CategoryRepository;
import com.gstech.Order.theta.repository.jpa.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    private Order order;
    private Category category;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        order = new Order();
        order.setId(1L);
        order.setProduct("Product1");
        order.setQuantity(10);
        order.setPrice(100.0);

        category = new Category();
        category.setId(1L);
        category.setName("Category1");
    }

    @Test
    void testCreateOrder() {
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        Order createdOrder = orderService.createOrder(order);
        assertNotNull(createdOrder);
        assertEquals(order.getId(), createdOrder.getId());
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void testGetOrderById() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        Optional<Order> foundOrder = orderService.getOrderById(1L);
        assertTrue(foundOrder.isPresent());
        assertEquals(order.getId(), foundOrder.get().getId());
        verify(orderRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllOrders() {
        when(orderRepository.findAll()).thenReturn(Arrays.asList(order));
        List<Order> orders = orderService.getAllOrders();
        assertFalse(orders.isEmpty());
        assertEquals(1, orders.size());
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    void testUpdateOrder() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        Order orderDetails = new Order();
        orderDetails.setProduct("UpdatedProduct");
        orderDetails.setQuantity(20);
        orderDetails.setPrice(200.0);

        Order updatedOrder = orderService.updateOrder(1L, orderDetails);
        assertNotNull(updatedOrder);
        assertEquals(orderDetails.getProduct(), updatedOrder.getProduct());
        verify(orderRepository, times(1)).findById(1L);
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void testDeleteOrder() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        doNothing().when(orderRepository).delete(order);
        orderService.deleteOrder(1L);
        verify(orderRepository, times(1)).findById(1L);
        verify(orderRepository, times(1)).delete(order);
    }

    @Test
    void testPatchOrder() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        Order orderDetails = new Order();
        orderDetails.setProduct("PatchedProduct");
        orderDetails.setQuantity(15);

        Order patchedOrder = orderService.patchOrder(1L, orderDetails);
        assertNotNull(patchedOrder);
        assertEquals(orderDetails.getProduct(), patchedOrder.getProduct());
        assertEquals(orderDetails.getQuantity(), patchedOrder.getQuantity());
        verify(orderRepository, times(1)).findById(1L);
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void testCreateCategory() {
        when(categoryRepository.save(any(Category.class))).thenReturn(category);
        Category createdCategory = orderService.createCategory(category);
        assertNotNull(createdCategory);
        assertEquals(category.getId(), createdCategory.getId());
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void testGetAllCategories() {
        when(categoryRepository.findAll()).thenReturn(Arrays.asList(category));
        List<Category> categories = orderService.getAllCategories();
        assertFalse(categories.isEmpty());
        assertEquals(1, categories.size());
        verify(categoryRepository, times(1)).findAll();
    }
}
