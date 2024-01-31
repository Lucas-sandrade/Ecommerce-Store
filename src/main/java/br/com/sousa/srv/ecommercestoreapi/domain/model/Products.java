package br.com.sousa.srv.ecommercestoreapi.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "products")
public class Products {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private Integer quantity;

    @Column
    private BigDecimal price;

    @Column
    private String description;
}
