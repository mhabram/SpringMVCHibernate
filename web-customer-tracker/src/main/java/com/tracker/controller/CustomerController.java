package com.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tracker.entity.Customer;
import com.tracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    //inject customer service
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/list")
    public String listCustomer(Model model) {
        List<Customer> customer = customerService.getCustomers();
        
        model.addAttribute("customers", customer);
        
        return "customer-list";
    }
}
