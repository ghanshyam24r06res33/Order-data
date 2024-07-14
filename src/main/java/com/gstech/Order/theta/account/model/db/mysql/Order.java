package com.gstech.Order.theta.account.model.db.mysql;




import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "order_table")
public class Order {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
