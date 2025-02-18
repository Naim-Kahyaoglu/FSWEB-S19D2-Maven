package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(lombok.AccessLevel.NONE) // Disable Lombok setter for 'id'
    private Long id;

    private String accountName;
    private Double moneyAmount;

    // Many-to-One relationship with Customer
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Custom getter that returns an int for JSON
    public int getId() {
        return id.intValue();
    }

    // Setter accepting Long
    public void setId(Long id) {
        this.id = id;
    }

    // Overloaded setter accepting int
    public void setId(int id) {
        this.id = (long) id;
    }
}
