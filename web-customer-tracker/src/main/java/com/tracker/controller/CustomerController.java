package com.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tracker.dao.CustomerDAO;
import com.tracker.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    //Inject the customer dao
    @Autowired
    private CustomerDAO customerDAO;
    
    @RequestMapping("/list")
    public String listCustomer(Model model) {
        List<Customer> customer = customerDAO.getCustomers();
        
        model.addAttribute("customers", customer);
        
        return "customer-list";
    }
}
