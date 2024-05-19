package com.buenoezandro.loans.controller.dto;

import com.buenoezandro.loans.domain.LoanType;

public record LoanResponse(LoanType type, Double interestRate) {
}