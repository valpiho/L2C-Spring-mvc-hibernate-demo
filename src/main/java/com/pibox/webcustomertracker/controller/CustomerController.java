package com.pibox.webcustomertracker.controller;

import com.pibox.webcustomertracker.dao.CustomerDAO;
import com.pibox.webcustomertracker.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerDAO customerDAO;

    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @RequestMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> customerList = customerDAO.getCustomers();
        model.addAttribute("customers", customerList);
        return "list-customers";
    }

}
