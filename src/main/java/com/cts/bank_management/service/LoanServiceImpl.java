package com.cts.bank_management.service;

import com.cts.bank_management.model.Loan;
import com.cts.bank_management.repository.LoanRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private final LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan applyForLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public Loan viewLoanDetails(Long loanId) {
        return loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found with id: " + loanId));
    }

    @Override
    public Loan saveUpdate(Long loanId, Loan loanDetails) {
        Loan existingLoan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found with id: " + loanId));
        
        existingLoan.setLoanAmount(loanDetails.getLoanAmount());
        existingLoan.setInterestRate(loanDetails.getInterestRate());
        existingLoan.setLoanDuration(loanDetails.getLoanDuration());
        // Update other fields as necessary

        return loanRepository.save(existingLoan);
    }

    @Override
    public List<Loan> viewAllLoans() {
        return loanRepository.findAll();
    }
}