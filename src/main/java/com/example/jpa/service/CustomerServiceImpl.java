package com.example.jpa.service;

import com.example.jpa.entity.Customer;
import com.example.jpa.entity.CustomerDto;
import com.example.jpa.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer entity = Customer.builder()
                                  .name(customerDto.getName())
                                  .address(customerDto.getAddress())
                                  .build();
        BeanUtils.copyProperties(customerDto, entity);
        entity = customerRepository.save(entity);
        BeanUtils.copyProperties(entity, customerDto);
        return customerDto;
    }

    @Override
    public List<Customer> customerList() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer;
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        Customer entity = Customer.builder()
                                  .name(customerDto.getName())
                                  .address(customerDto.getAddress())
                                  .build();
        BeanUtils.copyProperties(customerDto , entity);
        entity = customerRepository.save(entity);
        BeanUtils.copyProperties(entity , customerDto);
        return customerDto;
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customer = Customer.builder().build();
        customerRepository.deleteById(id);
        return customer;
    }
}
