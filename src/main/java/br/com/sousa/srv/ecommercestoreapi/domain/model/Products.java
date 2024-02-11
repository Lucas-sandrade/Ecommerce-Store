package br.com.sousa.srv.ecommercestoreapi.domain.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;


import java.math.BigDecimal;

@Entity
@Data
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @NotNull(message = "The quantity of the product cannot be zero")
    @Positive(message = "The quantity of the product must be positive")
    @Column
    private Integer quantity;

    @NotNull(message = "The price of the product cannot be zero")
    @Positive(message = "The product price must be greater than zero")
    @Column
    private BigDecimal price;

    @Column
    private String description;
}
