package com.cts.bank_management.service;

import com.cts.bank_management.model.Customer;

public interface CustomerService {
    void registerCustomer(Customer customer);
    Customer getCustomerDetails(String customerId);
}