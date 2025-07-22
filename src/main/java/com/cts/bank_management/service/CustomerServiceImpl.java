package com.cts.bank_management.service;

import com.cts.bank_management.model.Customer;
import com.cts.bank_management.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void registerCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer details cannot be null");
        }
        // Save the customer details in the repository
            customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerDetails(String customerId) {
        if (customerId == null || customerId.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty");
        }
        // Fetch the customer details from the repository
        return customerRepository.findById(Long.parseLong(customerId))
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));
    }
}