package com.pibox.webcustomertracker.service;

import com.pibox.webcustomertracker.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void addCustomer(Customer customer);

    Customer getCustomer(int id);
}
