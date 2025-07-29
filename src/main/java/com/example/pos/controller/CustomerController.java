package com.example.pos.controller;

import com.example.pos.dto.CustomerDTO;
import com.example.pos.services.CustomerService;
import com.example.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<StandardResponse> getAllCustomer() {
        List<CustomerDTO> allCustomer = customerService.getAllCustomer();
        return new ResponseEntity(new StandardResponse(200, "true", allCustomer), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity searchCustomer(@PathVariable String id) {
        CustomerDTO customer = customerService.searchCustomer(id);
        return new ResponseEntity(new StandardResponse(200, "true", customer), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO customer) {
        customerService.saveCustomer(customer);
        return new ResponseEntity(new StandardResponse(200, "done", null), HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCustomer(@RequestParam String id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity(new StandardResponse(200, "done", null), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO customer) {
        customerService.updateCustomer(customer);
        return new ResponseEntity(new StandardResponse(200, "done", null), HttpStatus.OK);
    }
}
