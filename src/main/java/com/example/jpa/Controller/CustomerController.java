package com.example.jpa.Controller;

import com.example.jpa.entity.CustomerDto;
import com.example.jpa.entity.Customer;
import com.example.jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    CustomerService service;

    @Autowired
    public CustomerController(CustomerService service){
        this.service = service;
    }

    //Path : /customer
    @PostMapping("/customer")
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return service.createCustomer(customerDto);
    }

    @GetMapping("/customerList")
    public List<Customer> customers(){
        return service.customerList();
    }

    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomer(@PathVariable Long id){
        return service.getCustomer(id);
    }

    @DeleteMapping("/customer/{id}")
    public Customer deleteCustomer(@PathVariable Long id){
        return service.deleteCustomer(id);
    }

//    @PutMapping("/customer/{id}")
//    public CustomerDto modifyCustomer(@RequestBody CustomerDto customerDto , @PathVariable Long id , Customer customer){
//        customer.setId(id);
//        return service.updateCustomer(customerDto);
//    }
}
