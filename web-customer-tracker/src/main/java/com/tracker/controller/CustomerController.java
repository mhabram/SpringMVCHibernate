package com.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Customer customer = new Customer();
        
        model.addAttribute("customer", customer);
        
        return "customer-form";
    }
    
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        //Save the customer using service
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }
    
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
        //Get the customer from db
        Customer customer = customerService.getCustomer(id);
        
        //Set the customer as model attribute
        model.addAttribute("customer", customer);
        
        //Send to form
        return "customer-form";
    }
}
