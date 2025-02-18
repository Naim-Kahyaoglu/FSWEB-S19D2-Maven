package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(lombok.AccessLevel.NONE) // Disable Lombok setter for 'id'
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private Double salary;

    // One-to-One relationship with Address
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    // One-to-Many relationship with Account
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

    // Custom getter that returns an int for JSON serialization (to match tests)
    public int getId() {
        return id.intValue();
    }

    // Custom setter accepting Long (used by JPA and internal operations)
    public void setId(Long id) {
        this.id = id;
    }

    // Overloaded setter accepting int (this will be invoked from your controller)
    public void setId(int id) {
        this.id = (long) id;
    }
}
