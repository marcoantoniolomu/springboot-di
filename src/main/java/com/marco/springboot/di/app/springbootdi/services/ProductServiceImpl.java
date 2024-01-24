package com.marco.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
// import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.marco.springboot.di.app.springbootdi.models.Product;
import com.marco.springboot.di.app.springbootdi.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository repository;

    // @Autowired
    // private Environment environment;

    @Value("${config.price.tax}")
    private Double tax;

    public ProductServiceImpl(@Qualifier("productJson") ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            // System.out.println("Autowired: " + environment.getProperty("config.price.tax", Double.class));
            // System.out.println("Value: " + tax);
            // Double priceTax = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
            Double priceTax = p.getPrice() * tax;
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

}
