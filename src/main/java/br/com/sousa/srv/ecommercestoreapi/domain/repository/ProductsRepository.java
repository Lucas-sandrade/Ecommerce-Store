package br.com.sousa.srv.ecommercestoreapi.domain.repository;

import br.com.sousa.srv.ecommercestoreapi.domain.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
}
