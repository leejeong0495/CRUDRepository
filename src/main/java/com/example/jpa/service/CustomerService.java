package com.example.jpa.service;

import com.example.jpa.entity.CustomerDto;
import com.example.jpa.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    List<Customer> customerList();
    Optional<Customer> getCustomer(Long id);
    CustomerDto updateCustomer(CustomerDto customerDto);
    Customer deleteCustomer(Long id);
}
