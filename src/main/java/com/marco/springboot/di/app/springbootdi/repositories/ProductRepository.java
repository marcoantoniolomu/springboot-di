package com.marco.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import com.marco.springboot.di.app.springbootdi.models.Product;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1L, "TV", 900L),
                new Product(2L, "PC", 1500L),
                new Product(3L, "SMARTPHONE", 430L),
                new Product(4L, "TABLET", 700L));
    }

    public List<Product> findAll() {
        return this.data;
    }

    public Product findById(Long id) {
        return this.data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
