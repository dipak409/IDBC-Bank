package com.niit;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IdbcBankDAO idbcBankDAO = new IdbcBankDAOimpl();
        App app=new App();


        System.out.println("**************************************************");
        int customerId = 1;
        app.greet();
        Accounts accounts= idbcBankDAO.getCustomerById(customerId);
        accounts.setAccountNumber(app.generateAccount());
        boolean result = idbcBankDAO.accountNumberGenerated(accounts);
        if(result)
        {
            System.out.println("Account Number is Generated successfully and your Customer Id is " +accounts.getCustomerId());
        }
        System.out.println("*****************************************************************");
        System.out.println();


        System.out.println("*************************Check Balance *************************");
        System.out.println();
        int customerID = 4;
        Accounts accounts1= idbcBankDAO.getCustomerById(customerID);
        accounts1.getAccountBalance();
        boolean result1 =idbcBankDAO.checkAccountBalance(accounts1);
        if(result1)
        {
           System.out.println("Your Balance is " + accounts1.getAccountBalance() + " and your customer id is :: "+accounts1.getCustomerId());
        }
        System.out.println("*****************************************************************");
        System.out.println();


        System.out.println("****************************************************************************");
        System.out.println();
        System.out.println("****************************** Withdraw  **********************************************");
        Accounts account2=new Accounts();
        idbcBankDAO.withdraw(account2);
        System.out.println("your withdrawal request is successfully approved.");
        System.out.println();
        System.out.println("****************************** **********************************************");
        System.out.println();

        System.out.println("****************************** Deposit  **********************************************");
        Accounts account=new Accounts();
        idbcBankDAO.Deposit(account);
        System.out.println("Amount is Deposited Successfully.");
        System.out.println();
        System.out.println("****************************** **********************************************");
        System.out.println();


        System.out.println("************************* Updated Intrest Rate For Saving Account ******************************");
        String accountType="Saving";
        Accounts accounts2= idbcBankDAO.getAccountTypeByName(accountType);

        accounts2.getUpdatedIntrestBalance();
        boolean result3 = idbcBankDAO.updatedIntrestBalance(accounts2);
        if(result3)
        {
            System.out.println("Your Updated Account Balance is " +accounts2.getUpdatedIntrestBalance()+" for customer Id :: "+accounts2.getCustomerId());
        }
        System.out.println();


        System.out.println("****************************** Updated Intrest Rate For Pay Account **********************************************");
        System.out.println();
        String accountType1="Pay";
        Accounts accounts3= idbcBankDAO.getAccountTypeByName(accountType1);
        accounts3.getUpdatedIntrestBalance();
        boolean result4=idbcBankDAO.updatedIntrestBalanceForPay(accounts3);

        if(result4)
        {
            System.out.println(" Your Account balance is updated ");
        }


        System.out.println("******************** Transaction Details of a Customer ***********************");
        System.out.println();
        System.out.println("             Transaction Details :: ");
        System.out.println("------------------------------------------------------------------");
        int customerID1 = 4;
        AccountTransaction accountTransaction= idbcBankDAO.getCustomerByIdforTransaction(customerID1);

        boolean results =idbcBankDAO.transactionDetails(accountTransaction);

        if(results)
        {
            System.out.println("Transaction Details for your customer id is :: "+accountTransaction.getCustomerId());
        }
        System.out.println("*****************************************************************");


    }
    public void greet()
    {
        System.out.println("Account is Opened Successfully....");
        System.out.println("Thank you for opening an Account in IDBC Bank");
    }
    public double generateAccount()
    {
        int maximumNumber=999999999;
        Random randomAccountNumber = new Random();
        double bankCode = 281;
        return bankCode + randomAccountNumber.nextInt(maximumNumber);
    }
}
