package com.example.yc2.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private int sold;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    public Product() {}

    public Product(String name, Category category, int sold) {
        this.name = name;
        this.category = category;
        this.sold = sold;
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getSold() {
        return sold;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
