package com.example.pos.services.impl;

import com.example.pos.dto.CustomerDTO;
import com.example.pos.entity.Customer;
import com.example.pos.handler.AppException;
import com.example.pos.repository.CustomerRepository;
import com.example.pos.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO customer) {
        if (customerRepository.existsById(customer.getId())) {
            throw new AppException("Customer Already Exist");
        }
        Customer savedCustomer = modelMapper.map(customer, Customer.class);
        customerRepository.save(savedCustomer);
    }

    @Override
    public void updateCustomer(CustomerDTO customer) {
        if (!(customerRepository.existsById(customer.getId()))) {
            throw new AppException("Customer Not Exist");
        }
        Customer updatedCustomer = modelMapper.map(customer, Customer.class);
        customerRepository.save(updatedCustomer);
    }

    @Override
    public void deleteCustomer(String id) {
        if (!(customerRepository.existsById(id))) {
            throw new AppException("Customer Not Exist");
        }
        Optional<Customer> searchedCustomer = customerRepository.findById(id);
        customerRepository.delete(searchedCustomer.get());
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if (!(customerRepository.existsById(id))) {
            throw new AppException("No Such Customer");
        }
        Optional<Customer> searchedCustomer = customerRepository.findById(id);
        CustomerDTO customer = modelMapper.map(searchedCustomer.get(), CustomerDTO.class);

        return customer;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> allCustomers = customerRepository.findAll();
        return modelMapper.map(allCustomers, new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }
}
