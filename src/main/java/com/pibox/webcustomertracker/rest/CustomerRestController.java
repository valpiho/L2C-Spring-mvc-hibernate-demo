package com.pibox.webcustomertracker.rest;

import com.pibox.webcustomertracker.entity.Customer;
import com.pibox.webcustomertracker.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found!");
        }
        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        customerService.addCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found!");
        }
        customerService.deleteCustomer(customerId);
        return "Customer deleted";
    }
}
