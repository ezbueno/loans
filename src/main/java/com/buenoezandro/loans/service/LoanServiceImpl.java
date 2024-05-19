package com.buenoezandro.loans.service;

import com.buenoezandro.loans.controller.dto.CustomerLoanRequest;
import com.buenoezandro.loans.controller.dto.CustomerLoanResponse;
import com.buenoezandro.loans.controller.dto.LoanResponse;
import com.buenoezandro.loans.domain.Loan;
import com.buenoezandro.loans.domain.LoanType;
import com.buenoezandro.loans.exception.LoanNotAvailableException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    @Override
    public CustomerLoanResponse checkLoanAvailability(CustomerLoanRequest loanRequest) {

        var customer = loanRequest.toCustomer();
        var loan = new Loan(customer);

        List<LoanResponse> loans = new ArrayList<>();

        if (loan.isPersonalLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
        }

        if (loan.isConsignmentLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsignmentLoanInterestRate()));
        }

        if (loan.isGuaranteedLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));
        }

        if (loans.isEmpty()) {
            loans.add(new LoanResponse(LoanType.NO_LOAN_AVAILABLE, 0.0));
            throw new LoanNotAvailableException("Loan not available");
        }

        return new CustomerLoanResponse(loanRequest.name(), loans);
    }
}