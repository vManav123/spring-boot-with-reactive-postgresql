package com.reactive.programming.controller;

import com.reactive.programming.model.Product;
import com.reactive.programming.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/")
    public Flux<Product> getAll(){
        return this.productService.getAllProducts();
    }

    @GetMapping(path = "/{productId}")
    public Mono<ResponseEntity<Product>> getProductById(@PathVariable int productId){
        return productService
                .getProductById(productId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/")
    public Mono<Product> createProduct(@RequestBody Mono<Product> productMono){
        return productMono.flatMap(productService::createProduct);
    }

    @PutMapping("/{productId}")
    public Mono<Product> updateProduct(@PathVariable Integer productId,
                                       @RequestBody Mono<Product> productMono){
        return this.productService.updateProduct(productId, productMono);
    }

    @DeleteMapping("/{productId}")
    public Mono<Void> deleteProduct(@PathVariable int productId){
        return this.productService.deleteProduct(productId);
    }

}