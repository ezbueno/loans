package com.buenoezandro.loans.domain;

public class Customer {
    private Integer age;
    private String cpf;
    private String name;
    private Double income;
    private String location;

    public Customer(Integer age, String cpf, String name, Double income, String location) {
        this.age = age;
        this.cpf = cpf;
        this.name = name;
        this.income = income;
        this.location = location;
    }

    public boolean isIncomeEqualOrLowerThan(double value) {
        return this.income <= value;
    }

    public boolean isIncomeEqualOrGreaterThan(double value) {
        return this.income >= value;
    }

    public boolean isIncomeBetween(double minValue, double maxValue) {
        return this.income >= minValue && this.income <= maxValue;
    }

    public boolean isAgeLowerThan(int value) {
        return this.age < value;
    }

    public boolean isFromLocation(String location) {
        return this.location.equalsIgnoreCase(location);
    }
}