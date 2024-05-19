package com.buenoezandro.loans.service;

import com.buenoezandro.loans.controller.dto.CustomerLoanRequest;
import com.buenoezandro.loans.controller.dto.CustomerLoanResponse;

public interface LoanService {
    CustomerLoanResponse checkLoanAvailability(CustomerLoanRequest customerLoanRequest);
}