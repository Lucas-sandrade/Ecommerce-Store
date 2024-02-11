package br.com.sousa.srv.ecommercestoreapi.controller;

import br.com.sousa.srv.ecommercestoreapi.domain.exception.ProductsNotFoundException;
import br.com.sousa.srv.ecommercestoreapi.domain.model.Products;
import br.com.sousa.srv.ecommercestoreapi.domain.service.ProductsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.BeanUtils;
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
    public List<Products> get() {
        return productsService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getById(@PathVariable Long id) {
        Optional<Products> products = productsService.get(id);

        if (products.isPresent()) {
            return ResponseEntity.ok(products.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity add(@Valid
                              @RequestBody Products products) {
        products = productsService.create(products);

        return ResponseEntity.status(HttpStatus.CREATED).body(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Products updatedProductData) {
        try {
            Optional<Products> product = productsService.get(id);

            if (product.isPresent()) {
                Products existingProduct = product.get();

                BeanUtils.copyProperties(updatedProductData, existingProduct, "id");

                Products updatedProduct = productsService.create(existingProduct);

                return ResponseEntity.ok(updatedProduct);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (ProductsNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Products> delete(@PathVariable Long id) {
        try {
            productsService.Delete(id);
            return ResponseEntity.noContent().build();
        } catch (ProductsNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
