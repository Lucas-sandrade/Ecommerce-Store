package br.com.sousa.srv.ecommercestoreapi.controller;

import br.com.sousa.srv.ecommercestoreapi.domain.model.Customer;
import br.com.sousa.srv.ecommercestoreapi.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id) {
        return customerService.get(id);
    }

}
