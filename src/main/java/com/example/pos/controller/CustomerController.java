package com.example.pos.controller;

import com.example.pos.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {

    @GetMapping
    public CustomerDTO getCustomer(@RequestBody CustomerDTO dto) {
        return dto;
    }
}
