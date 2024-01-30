package br.com.sousa.srv.ecommercestoreapi.domain.service;

import br.com.sousa.srv.ecommercestoreapi.domain.model.Products;

import java.util.List;
import java.util.Optional;

public interface ProductsService {

    List<Products> getAll();
    Optional<Products> get(Long id);
    Products create(Products products);
    void delete (Long id);

}
