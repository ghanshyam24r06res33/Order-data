package com.gstech.Order.theta.account.model.db.mysql;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "category_table")
public class Category {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cname")
    private String name;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "total_order")
    private int totalOrder;

}
