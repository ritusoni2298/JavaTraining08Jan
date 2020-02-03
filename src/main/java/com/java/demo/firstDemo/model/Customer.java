package com.java.demo.firstDemo.model;

import com.sun.tools.javac.util.List;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;

//query - > select * from customers
//insert -> insert into table values ();

//jpa -> repositories -> get , put , post , delete

//DAO - > Data Access Object

@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName; //-> first_name

    private String lastName;

    private String address;

    private String product;

//    @OneToMany
//    private ArrayList<Order> orders =new ArrayList<>();

    private String emailId;

    public Customer(){

    }

    public Customer(String firstName, String lastName, String address, String product, String emailId){
        this.firstName= firstName;
        this.lastName=lastName;
        this.address=address;
        this.product=product;
        this.emailId=emailId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("name=").append(firstName+" "+lastName).append("  address="+address+" "+emailId+"  "+product);

        return st.toString();
    }
}


