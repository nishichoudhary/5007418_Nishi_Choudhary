package com.book.controller;

import org.springframework.web.bind.annotation.*;

import com.book.model.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) 
    {
        return customer;
    }
    
    @PostMapping("/register")
    public String registerCustomer(
        @RequestParam String name,
        @RequestParam String email) 
    {
        return "Customer registered with name: " + name + " and email: " + email;
    }

}

