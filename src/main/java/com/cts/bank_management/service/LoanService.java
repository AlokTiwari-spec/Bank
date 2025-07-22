package com.cts.bank_management.service;

import com.cts.bank_management.model.Loan;
import java.util.List;

import org.springframework.stereotype.Service;

@Service

public interface LoanService {
    Loan applyForLoan(Loan loan);
    Loan viewLoanDetails(Long loanId);
    Loan saveUpdate(Long loanId, Loan loan);
    List<Loan> viewAllLoans();
}
