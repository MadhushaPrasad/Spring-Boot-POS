package com.example.pos.services.impl;

import com.example.pos.entity.Customer;
import com.example.pos.repository.CustomerRepository;
import com.example.pos.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
     CustomerRepository customerRepository;

    @Override
    public void saveCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Customer updatedCustomer = customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        Optional<Customer> searchedCustomer = customerRepository.findById(id);
        customerRepository.delete(searchedCustomer.get() );
    }

    @Override
    public Customer searchCustomer(String id) {
        Optional<Customer> searchedCustomer = customerRepository.findById(id);

        return searchedCustomer.get();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}
