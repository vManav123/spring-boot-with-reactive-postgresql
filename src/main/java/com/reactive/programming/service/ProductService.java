package com.reactive.programming.service;

import com.reactive.programming.dao.ProductRepository;
import com.reactive.programming.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Flux<Product> getAllProducts() {
        return this.repository.findAll();
    }

    public Mono<Product> getProductById(Integer productId) {
        return repository.findById(productId);
    }

    public Mono<Product> createProduct(final Product product) {
        return repository.save(product);
    }

    public Mono<Product> updateProduct(Integer productId , final Mono<Product> productMono) {
        return repository
                .findById(productId)
                .flatMap(
                        p -> productMono
                                .map(u -> {
                                    p.setDescription(u.getDescription());
                                    p.setPrice(u.getPrice());
                                    return p;
                                })
                )
                .flatMap(p -> this.repository.save(p));
    }

    public Mono<Void> deleteProduct(final int id) {
        return repository.deleteById(id);
    }

}
