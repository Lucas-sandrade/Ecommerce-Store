package br.com.sousa.srv.ecommercestoreapi.domain.service.impl;

import br.com.sousa.srv.ecommercestoreapi.domain.exception.CustomerNotFoundException;
import br.com.sousa.srv.ecommercestoreapi.domain.model.Customer;
import br.com.sousa.srv.ecommercestoreapi.domain.repository.CustomerRepository;
import br.com.sousa.srv.ecommercestoreapi.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;


    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Customer get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void create(Customer customer) {
        customer.getAddress().forEach(address -> {
            address.setCustomer(customer);
        });
        repository.save(customer);
    }
}
