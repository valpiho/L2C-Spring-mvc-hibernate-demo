package com.pibox.webcustomertracker.service;

import com.pibox.webcustomertracker.dao.CustomerDAO;
import com.pibox.webcustomertracker.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }
}
