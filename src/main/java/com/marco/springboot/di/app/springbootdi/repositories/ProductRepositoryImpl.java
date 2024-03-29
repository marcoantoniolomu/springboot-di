package com.marco.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
// import org.springframework.web.context.annotation.RequestScope;
// import org.springframework.web.context.annotation.SessionScope;

import com.marco.springboot.di.app.springbootdi.models.Product;

@Primary
// @RequestScope
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "TV", 900L),
                new Product(2L, "PC", 1500L),
                new Product(3L, "SMARTPHONE", 430L),
                new Product(4L, "TABLET", 700L));
    }

    @Override
    public List<Product> findAll() {
        return this.data;
    }

    @Override
    public Product findById(Long id) {
        return this.data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
