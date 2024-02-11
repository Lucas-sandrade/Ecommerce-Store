package br.com.sousa.srv.ecommercestoreapi.domain.service.impl;

import br.com.sousa.srv.ecommercestoreapi.domain.exception.ProductsNotFoundException;
import br.com.sousa.srv.ecommercestoreapi.domain.model.Products;
import br.com.sousa.srv.ecommercestoreapi.domain.repository.ProductsRepository;
import br.com.sousa.srv.ecommercestoreapi.domain.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private final ProductsRepository productsRepository;

    @Override
    public List<Products> getAll() {
        return productsRepository.findAll();
    }

    @Override
    public Optional<Products> get(Long id) {
        return productsRepository.findById(id);
    }

    @Override
    public Products create(Products products) {
        return productsRepository.save(products);
    }

    @Override
    public void Delete(Long id) {
        if (!productsRepository.existsById(id)) {
            throw new ProductsNotFoundException(id);
        }
        productsRepository.deleteById(id);

    }
}
