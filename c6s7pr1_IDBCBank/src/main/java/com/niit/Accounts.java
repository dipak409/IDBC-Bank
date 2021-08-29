package com.niit;

public class Accounts {
    private double accountNumber;
    private String accountType;
    private String accountBalance;
    private double customerId;
    private String updatedIntrestBalance;


    public Accounts(double accountNumber, String accountType, String accountBalance, double customerId, String updatedIntrestBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.customerId = customerId;

        this.updatedIntrestBalance = updatedIntrestBalance;
    }
    public Accounts()
    {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.customerId = customerId;
        this.updatedIntrestBalance = updatedIntrestBalance;
    }
    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getCustomerId() {
        return customerId;
    }

    public void setCustomerId(double customerId) {
        this.customerId = customerId;
    }

    public String getUpdatedIntrestBalance() {
        return updatedIntrestBalance;
    }

    public void setUpdatedIntrestBalance(String updatedIntrestBalance) {
        this.updatedIntrestBalance = updatedIntrestBalance;
    }
}
