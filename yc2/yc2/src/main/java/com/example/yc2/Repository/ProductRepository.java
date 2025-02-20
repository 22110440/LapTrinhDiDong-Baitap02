package com.example.yc2.Repository;

import com.example.yc2.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);
    List<Product> findTop10ByOrderBySoldDesc();
    List<Product> findTop10ByCreatedAtAfterOrderByCreatedAtDesc(Date date);
}
