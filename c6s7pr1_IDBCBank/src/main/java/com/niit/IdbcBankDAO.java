package com.niit;

public interface IdbcBankDAO {
    boolean accountNumberGenerated(Accounts accounts);
    Accounts getCustomerById(int customerId);
    boolean checkAccountBalance(Accounts accounts);
    Accounts withdraw(Accounts accounts);
    boolean updatedIntrestBalance(Accounts accounts);
    Accounts getAccountTypeByName(String accountType);
    boolean updatedIntrestBalanceForPay(Accounts accounts);
    Accounts Deposit(Accounts accounts);
    boolean transactionDetails(AccountTransaction accountTransaction);
    AccountTransaction getCustomerByIdforTransaction(int customerId);

}
