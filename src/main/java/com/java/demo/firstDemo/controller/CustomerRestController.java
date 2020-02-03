package com.java.demo.firstDemo.controller;

import com.java.demo.firstDemo.model.Customer;
import com.java.demo.firstDemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerRestController {
    @Autowired
    CustomerRepository customerRepository;

    //get
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    //post
    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customer)
    {
        return customerRepository.save(customer);
    }

    //put
    @PutMapping("/customers/{id}")
    public Optional<Customer> updateCustomer(@PathVariable(value = "id") Long customerId, @Valid @RequestBody Customer customer){
        return customerRepository.findById(customerId).map(customer1 -> {
            customer1.setFirstName(customer.getFirstName());
            customer1.setAddress(customer.getAddress());
            customer1.setLastName(customer.getLastName());
            customer1.setEmailId(customer.getEmailId());
            customer1.setLastName(customer.getLastName());
            customer1.setProduct(customer.getProduct());
            return customerRepository.save(customer1);
        }  );
    }

    //return name parameter
//list=[1,2,3,4]
    //f(n)=n*2
    //[2,4,6,8]=map(func,iterable)


    //delete
    @DeleteMapping("/customers/{id}")
    public Optional<?> deleteById(@PathVariable Long id){
        return customerRepository.findById(id).map(customer -> {
            customerRepository.delete(customer);
            return ResponseEntity.ok().build();
        });
    }
}
