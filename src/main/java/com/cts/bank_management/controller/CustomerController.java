package com.cts.bank_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cts.bank_management.model.Customer;
import com.cts.bank_management.model.Loan;
import com.cts.bank_management.service.CustomerService;
import com.cts.bank_management.service.LoanService;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private LoanService loanService;


    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
        try {
            customerService.registerCustomer(customer);
            return ResponseEntity.ok("Customer registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error registering customer: " + e.getMessage());
        }
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerDetails(@PathVariable String customerId) {
        try {
            Customer customer = customerService.getCustomerDetails(customerId);
            return ResponseEntity.ok(customer);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/apply-loan")
    public ResponseEntity<String> applyForLoan(@RequestBody Loan loan) {
        try {
            loanService.applyForLoan(loan);
            return ResponseEntity.ok("Loan application submitted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error applying for loan: " + e.getMessage());
        }
    }

    @GetMapping("/loan/{loanId}")
    public ResponseEntity<Loan> getLoanDetails(@PathVariable String loanId) {
        try {
            Loan loan = loanService.viewLoanDetails(Long.parseLong
            (loanId));
            return ResponseEntity.ok(loan);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/loans")
    public ResponseEntity<List<Loan>> findAllLoans() {
        try {
            List<Loan> loans = loanService.viewAllLoans();
            return ResponseEntity.ok(loans);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/update-loan/{loanId}")
    public ResponseEntity<String> updateLoan(@PathVariable String loanId, @RequestBody Loan loan) {
        try {
            loanService.saveUpdate(Long.parseLong(loanId), loan);
            return ResponseEntity.ok("Loan updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating loan: " + e.getMessage());
        }
    }
}