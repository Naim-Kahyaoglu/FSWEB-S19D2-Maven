package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // [GET] /customer - Get all customers
    @GetMapping("/customer")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    // [GET] /customer/{id} - Get customer by id
    @GetMapping("/customer/{id}")
    public Customer find(@PathVariable Long id) {
        return customerService.find(id);
    }

    @PostMapping("/customer")
    public CustomerResponse save(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.save(customer);
        return new CustomerResponse(savedCustomer.getId(), savedCustomer.getEmail(), savedCustomer.getSalary());
    }



    // [PUT] /customer/{id} - Update customer by id
    @PutMapping("/customer/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer customer) {
        customer.setId(id); // Now id is already a Long, so this works fine.
        return customerService.save(customer);
    }

    // [DELETE] /customer/{id} - Delete customer by id
    @DeleteMapping("/customer/{id}")
    public Customer delete(@PathVariable Long id) {
        return customerService.delete(id);
    }
}
