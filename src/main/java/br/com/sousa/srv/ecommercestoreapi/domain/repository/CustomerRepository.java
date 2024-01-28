package br.com.sousa.srv.ecommercestoreapi.domain.repository;

import br.com.sousa.srv.ecommercestoreapi.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
