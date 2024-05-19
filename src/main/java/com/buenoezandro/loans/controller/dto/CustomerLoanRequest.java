package com.buenoezandro.loans.controller.dto;

import com.buenoezandro.loans.domain.Customer;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record CustomerLoanRequest(
        @Min(value = 18, message = "Age should be at least 18 years old")
        @NotNull
        Integer age,
        @CPF(message = "Invalid CPF")
        String cpf,
        @NotBlank(message = "Name cannot be blank")
        String name,
        @Min(value = 1000, message = "Income should be at least 1000")
        @NotNull
        Double income,
        @NotBlank(message = "Location cannot be blank")
        String location
) {
    public Customer toCustomer() {
        return new Customer(age, cpf, name, income, location);
    }
}