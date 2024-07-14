package com.gstech.Order.theta.repository.jpa;




//package com.example.demo.repository;


import com.gstech.Order.theta.account.model.db.mysql.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
