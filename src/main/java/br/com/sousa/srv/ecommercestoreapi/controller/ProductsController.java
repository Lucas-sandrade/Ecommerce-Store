package br.com.sousa.srv.ecommercestoreapi.controller;

import br.com.sousa.srv.ecommercestoreapi.domain.model.Products;
import br.com.sousa.srv.ecommercestoreapi.domain.service.ProductsService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/v1/api/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping
    public List<Products> get(){
        return  productsService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Products> getById(@PathVariable Long id){
    Optional<Products> products = productsService.get(id);

    if(products.isPresent()) {
        return ResponseEntity.ok(products.get());
    }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Products products){
        products = productsService.create(products);

        return ResponseEntity.status(HttpStatus.CREATED).body(products);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        productsService.delete(id);
    }
}
