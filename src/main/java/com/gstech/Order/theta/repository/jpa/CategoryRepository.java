package com.gstech.Order.theta.repository.jpa;
import com.gstech.Order.theta.account.model.db.mysql.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
