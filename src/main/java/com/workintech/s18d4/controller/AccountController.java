package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.AccountService;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    // [GET] /account - Get all accounts
    @GetMapping("/account")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    // [GET] /account/{id} - Get account by id
    @GetMapping("/account/{id}")
    public Account find(@PathVariable Long id) {
        return accountService.find(id);
    }

    // [POST] /account/{customerId} - Create account associated with a customer
    @PostMapping("/account/{customerId}")
    public Account save(@PathVariable Long customerId, @RequestBody Account account) {
        Customer customer = customerService.find(customerId);
        account.setCustomer(customer);
        return accountService.save(account);
    }

    // [PUT] /account/{customerId} - Update account and associate with customer
    @PutMapping("/account/{customerId}")
    public Account update(@PathVariable Long customerId, @RequestBody Account account) {
        Customer customer = customerService.find(customerId);
        account.setCustomer(customer);
        return accountService.save(account);
    }

    // [DELETE] /account/{id} - Delete account by id
    @DeleteMapping("/account/{id}")
    public Account delete(@PathVariable Long id) {
        return accountService.delete(id);
    }
}
