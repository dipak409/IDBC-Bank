package com.niit;

import java.sql.*;

public class IdbcBankDAOimpl implements IdbcBankDAO{
    private Connection connection;

    public IdbcBankDAOimpl() {
        connection = MySqlConnection.getConnection();
    }

    @Override
    public boolean accountNumberGenerated(Accounts accounts) {
        try
        {
            String query = "update accounts set accountNumber = ? where customerId = ?";
            PreparedStatement preparedStatement =connection.prepareStatement(query);
            preparedStatement.setDouble(1,accounts.getAccountNumber());
            preparedStatement.setDouble(2,accounts.getCustomerId());
            int count=preparedStatement.executeUpdate();
            if(count>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
            return false;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkAccountBalance(Accounts accounts) {
        try
        {
            String query = "select accountBalance from accounts where customerId = ?";
            PreparedStatement preparedStatement =connection.prepareStatement(query);
            //preparedStatement.setDouble(1,accounts.getAccountNumber());
            preparedStatement.setDouble(1,accounts.getCustomerId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
            return false;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
    }




    @Override
    public boolean updatedIntrestBalance(Accounts accounts) {
        try
        {
            String query = "update accounts set updatedIntrestBalance = accountBalance+(accountBalance*0.025) where accountType = ?";
            PreparedStatement preparedStatement =connection.prepareStatement(query);
            preparedStatement.setString(1,accounts.getAccountType());
            int count = preparedStatement.executeUpdate();
            if(count>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
            return false;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updatedIntrestBalanceForPay(Accounts accounts) {
        try
        {
            String query = "update accounts set updatedIntrestBalance = accountBalance where accountType = ?";
            PreparedStatement preparedStatement =connection.prepareStatement(query);
            preparedStatement.setString(1,accounts.getAccountType());
            int count = preparedStatement.executeUpdate();
            if(count>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
            return false;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Accounts getCustomerById(int customerId) {
        try
        {
            String query = "select * from accounts where customerId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1,customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {

                Accounts accounts = new Accounts(resultSet.getDouble("accountNumber"),
                        resultSet.getString("accountType"),resultSet.getString("accountBalance"),
                        resultSet.getDouble("customerId"),resultSet.getString("updatedIntrestBalance"));
                return accounts;
            }
            else
            {
                return null;
            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
            return null;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
    }

    public Accounts getAccountTypeByName(String accountType) {
        try
        {
            String query = "select * from accounts where accountType = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,accountType);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {

                Accounts accounts = new Accounts(resultSet.getDouble("accountNumber"),
                        resultSet.getString("accountType"),resultSet.getString("accountBalance"),
                        resultSet.getDouble("customerId"),resultSet.getString("updatedIntrestBalance"));
                return accounts;
            }
            else
            {
                return null;
            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
            return null;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
    }

    public Accounts withdraw(Accounts accounts)
    {
        String QUERY = "select * from accounts;";
        try
        {
            String query="UPDATE accounts a JOIN accounttransaction t on a.customerId=t.customerId set a.accountBalance = a.accountBalance - t.withdraw";
            Statement statement= connection.createStatement();
            statement.executeUpdate(query);
            ResultSet resultSet = statement.executeQuery(QUERY);
            while(resultSet.next())
            {
                 accounts = new Accounts(resultSet.getDouble("accountNumber"),
                        resultSet.getString("accountType"),resultSet.getString("accountBalance")
                        ,resultSet.getDouble("customerId"),resultSet.getString("updatedIntrestBalance"));

            }
            return accounts;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Accounts Deposit(Accounts accounts) {
        String QUERY = "select * from accounts;";
        try
        {
            String query="UPDATE accounts a JOIN accounttransaction t on a.customerId=t.customerId set a.accountBalance = a.accountBalance + t.deposit";
            Statement statement= connection.createStatement();
            statement.executeUpdate(query);
            ResultSet resultSet = statement.executeQuery(QUERY);
            while(resultSet.next())
            {
                accounts = new Accounts(resultSet.getDouble("accountNumber"),
                        resultSet.getString("accountType"),resultSet.getString("accountBalance")
                        ,resultSet.getDouble("customerId"),resultSet.getString("updatedIntrestBalance"));
            }
            return accounts;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean transactionDetails(AccountTransaction accountTransaction) {
        try
        {
            String query = "select * from accounttransaction where customerId = ?";
            PreparedStatement preparedStatement =connection.prepareStatement(query);
            //preparedStatement.setDouble(1,accounts.getAccountNumber());
            preparedStatement.setDouble(1,accountTransaction.getCustomerId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                System.out.println("Transaction Id :: "+accountTransaction.getTransactionId());
                System.out.println("Transaction Date :: "+accountTransaction.getTransactionDate());
                System.out.println("withdraw :: "+accountTransaction.getWithdraw());
                System.out.println("Deposit :: "+accountTransaction.getDeposit());
                System.out.println("Customer Id :: "+accountTransaction.getCustomerId());
                System.out.println("Withdraw Type :: "+accountTransaction.getWithdrawType());
                System.out.println("Deposit Type :: "+accountTransaction.getDepositType());
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
            return false;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
    }

    public AccountTransaction getCustomerByIdforTransaction(int customerId) {
        try
        {
            String query = "select * from accounttransaction where customerId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1,customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                AccountTransaction accountTransaction = new AccountTransaction(resultSet.getDouble("transactionId"),
                        resultSet.getString("transactionDate"),resultSet.getDouble("withdraw"),
                        resultSet.getDouble("deposit"),resultSet.getDouble("customerId"),
                        resultSet.getString("withdrawType"),resultSet.getString("depositType"));
                return accountTransaction;
            }
            else
            {
                return null;
            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
            return null;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
    }
}
