package com.pibox.webcustomertracker.dao;

import com.pibox.webcustomertracker.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void addCustomer(Customer customer);

    Customer getCustomer(int id);
}
