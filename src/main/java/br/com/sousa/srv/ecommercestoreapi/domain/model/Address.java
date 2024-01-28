package br.com.sousa.srv.ecommercestoreapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer_address")
public class Address {

    @Id
    private Long id;

    @Column
    private String street;

    @Column
    private String neighborhood;

    @Column
    private String zipCode;

    @Column
    private String city;

    @Column
    private String state;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
