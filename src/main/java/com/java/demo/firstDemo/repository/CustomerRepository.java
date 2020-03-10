package com.java.demo.firstDemo.repository;


import com.java.demo.firstDemo.model.Customer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findByEmailId(String emailId);

}

//@Configuration()
//@EnableAutoConfiguration
////pagination and sorting

