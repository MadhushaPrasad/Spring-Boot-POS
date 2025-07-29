package com.example.pos.controller;

import com.example.pos.dto.CustomerDTO;
import com.example.pos.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/{id}")
    public CustomerDTO searchCustomer(@PathVariable String id) {
        return customerService.searchCustomer(id);
    }

    @PostMapping()
    public void saveCustomer(@RequestBody CustomerDTO customer){
        customerService.saveCustomer(customer);
    }

    @DeleteMapping(params = {"id"})
    public void deleteCustomer(@RequestParam String id){
        customerService.deleteCustomer(id);
    }

    @PutMapping
    public void updateCustomer(@RequestBody CustomerDTO customer){
        customerService.updateCustomer(customer);
    }
}
