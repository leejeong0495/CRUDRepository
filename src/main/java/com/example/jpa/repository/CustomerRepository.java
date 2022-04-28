package com.example.jpa.repository;

import com.example.jpa.entity.Customer;
import com.example.jpa.entity.CustomerDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}