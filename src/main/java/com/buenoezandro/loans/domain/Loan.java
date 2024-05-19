package com.buenoezandro.loans.domain;

import com.buenoezandro.loans.exception.LoanNotAvailableException;

public class Loan {
    private final Customer customer;
    private static final String LOAN_NOT_AVAILABLE = "Loan not available";

    public Loan(Customer customer) {
        this.customer = customer;
    }

    public boolean isPersonalLoanAvailable() {
        return basicLoanAvailable();
    }

    public boolean isConsignmentLoanAvailable() {
        return customer.isIncomeEqualOrGreaterThan(5000.00);
    }

    public boolean isGuaranteedLoanAvailable() {
        return basicLoanAvailable();
    }

    public double getPersonalLoanInterestRate() {
        if (isPersonalLoanAvailable()) {
            return 4.0;
        }
        throw new LoanNotAvailableException(LOAN_NOT_AVAILABLE);
    }

    public double getConsignmentLoanInterestRate() {
        if (isConsignmentLoanAvailable()) {
            return 2.0;
        }
        throw new LoanNotAvailableException(LOAN_NOT_AVAILABLE);
    }

    public double getGuaranteedLoanInterestRate() {
        if (isGuaranteedLoanAvailable()) {
            return 3.0;
        }
        throw new LoanNotAvailableException(LOAN_NOT_AVAILABLE);
    }

    private boolean basicLoanAvailable() {
        if (customer.isIncomeEqualOrLowerThan(3000.00)) {
            return true;
        }

        return customer.isIncomeBetween(3000.00, 5000.00)
                && customer.isAgeLowerThan(30)
                && customer.isFromLocation("SP");
    }
}