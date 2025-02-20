package com.example.yc2.Service;

import com.example.yc2.Model.Product;
import com.example.yc2.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public List<Product> getTopSoldProducts() {
        return productRepository.findTop10ByOrderBySoldDesc();
    }

    public List<Product> getRecentProducts() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        Date sevenDaysAgo = calendar.getTime();
        return productRepository.findTop10ByCreatedAtAfterOrderByCreatedAtDesc(sevenDaysAgo);
    }
}
