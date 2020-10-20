package com.pibox.webcustomertracker.dao;

import com.pibox.webcustomertracker.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();
}
