package com.pibox.webcustomertracker.controller;

import com.pibox.webcustomertracker.entity.Customer;
import com.pibox.webcustomertracker.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> customerList = customerService.getCustomers();
        model.addAttribute("customers", customerList);
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/customer/list";
    }

}
