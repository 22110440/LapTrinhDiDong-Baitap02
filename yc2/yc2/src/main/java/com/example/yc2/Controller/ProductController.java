package com.example.yc2.Controller;

import com.example.yc2.Model.Product;
import com.example.yc2.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProductsByCategory(@RequestParam Long categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    @GetMapping("/top-sold")
    public List<Product> getTopSoldProducts() {
        return productService.getTopSoldProducts();
    }

    @GetMapping("/recent")
    public List<Product> getRecentProducts() {
        return productService.getRecentProducts();
    }
}
