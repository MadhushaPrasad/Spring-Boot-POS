package com.example.pos.controller;

import com.example.pos.dto.CustomerDTO;
import com.example.pos.entity.Customer;
import com.example.pos.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public void getCustomer(@RequestBody CustomerDTO dto) {
        Customer customer = new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary());
        customerService.saveCustomer(customer);
    }
}
