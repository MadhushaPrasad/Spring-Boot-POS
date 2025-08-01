package com.example.pos.services;

import com.example.pos.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customer);

    void updateCustomer(CustomerDTO customer);

    void deleteCustomer(String id);

    CustomerDTO searchCustomer(String id);

    List<CustomerDTO> getAllCustomer();
}
