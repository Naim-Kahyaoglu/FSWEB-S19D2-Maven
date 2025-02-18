package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private Integer no;
    private String city;
    private String country;

    // Optional field
    private String description;

    // One-to-One mapping back to Customer (optional inverse mapping)
    @OneToOne(mappedBy = "address")
    private Customer customer;
}
