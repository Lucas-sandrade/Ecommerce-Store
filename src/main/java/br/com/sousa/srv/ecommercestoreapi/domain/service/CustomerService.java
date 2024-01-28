package br.com.sousa.srv.ecommercestoreapi.domain.service;

import br.com.sousa.srv.ecommercestoreapi.domain.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();

    Customer get(Long id);

    void delete(Long id);

    void create(Customer customer);

}
