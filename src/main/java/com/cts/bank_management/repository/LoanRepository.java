package com.cts.bank_management.repository;

import com.cts.bank_management.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    // Custom query methods can be defined here if needed
    Loan save(Loan loan);
    
    Optional<Loan> findById(Long id);

    List<Loan> findAll();
}