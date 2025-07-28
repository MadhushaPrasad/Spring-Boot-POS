package com.example.pos.services.impl;

import com.example.pos.entity.Customer;
import com.example.pos.repository.CustomerRepository;
import com.example.pos.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
     CustomerRepository customerRepository;

    @Override
    public void saveCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
    }
}
