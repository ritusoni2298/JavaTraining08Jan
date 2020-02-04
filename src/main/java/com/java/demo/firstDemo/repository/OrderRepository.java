package com.java.demo.firstDemo.repository;

import com.java.demo.firstDemo.model.Customer;
import com.java.demo.firstDemo.model.Order;
//import com.sun.tools.javac.util.List;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> findByCustomer(Customer customer);
}
