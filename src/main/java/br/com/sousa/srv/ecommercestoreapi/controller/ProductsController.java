package br.com.sousa.srv.ecommercestoreapi.controller;

import br.com.sousa.srv.ecommercestoreapi.domain.model.Products;
import br.com.sousa.srv.ecommercestoreapi.domain.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/api/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping
    public List<Products> get(){
        return  productsService.getAll();
    }
    @PostMapping
    public Products add(@RequestBody Products products){
        return productsService.create(products);
    }

}
