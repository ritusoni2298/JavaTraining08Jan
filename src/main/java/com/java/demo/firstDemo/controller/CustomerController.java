package com.java.demo.firstDemo.controller;


import com.java.demo.firstDemo.model.Customer;
import com.java.demo.firstDemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    //get

    //method
    //1. Rest Controllers-> Customer, List<Customers>, void
    //2. ModelAndView ->
    //Model -> object to be provided to the view part
    //String -> We can provide only the view.-> index.html

    @RequestMapping("/list")
    public String show(Model model){
       model.addAttribute("customers",customerRepository.findAll());
//       model.setViewName("index");
       return "index";
    }

    //post
    @PostMapping("/add")
    public String addCustomer(@Valid Customer customer){
        customerRepository.save(customer);
//        model.addObject("customers",customerRepository.findAll());
//        model.setViewName("redirect:/list");
        return "redirect:/list";
    }

    @GetMapping("/add")
    public String showForm(Customer customer){
        return "add-customer";
    }
//////    @PostMapping("/add")
//    //put
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model)throws Exception{
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            model.addAttribute("customer",customer.get());
            return "update-customer";
        }else{
            model.addAttribute("message","This id does not exists");
            return "index";
        }

    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable Long id, @Valid Customer customer, Model model){
            customerRepository.save(customer);
            model.addAttribute("customers",customerRepository.findAll());
            return "index";

    }

    //delete
    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) throws Exception {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
            customerRepository.delete(customer.get());
            return "redirect:/list";
        }else {
            throw new Exception("invalid");
        }
    }

}
