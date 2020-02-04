package com.java.demo.firstDemo.controller;

import com.java.demo.firstDemo.model.Customer;
import com.java.demo.firstDemo.model.Order;
import com.java.demo.firstDemo.repository.CustomerRepository;
import com.java.demo.firstDemo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class OrderRestController {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;
    //get
    @GetMapping("/customers/{customerId}/orders")
    public List<Order> getAllOrders(@PathVariable(value="customerId") Long id) throws Exception {
        Optional<Customer> customer= customerRepository.findById(id);
        return orderRepository.findByCustomer(customer.get());
    }

    @PostMapping("/customers/{customerId}/orders")
    public Order addOrder(@PathVariable(value="customerId") Long id, @Valid @RequestBody Order order) throws Exception {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            order.setCustomer(customer.get());
            return orderRepository.save(order);
        }else{
            throw new Exception("invalid");
        }
    }
    //put and delete of mapped models



    //post


}
