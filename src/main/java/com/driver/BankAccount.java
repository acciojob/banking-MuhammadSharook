package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        if(sum > 9*digits)
        {
            throw new Exception("Account Number can not be generated");
        }
        else {
            int[] acc_no = new int[digits];
            for(int i = 0; i < digits; i++)
            {
                if(sum > 9)
                {
                    acc_no[i] = 9;
                    sum -= 9;
                }
                else {
                    acc_no[i] = sum;
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int d : acc_no)
            {
                sb.append(d);
            }
            return sb.toString();
        }
    }

    public void deposit(double amount) {
        //add amount to balance
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance - amount < minBalance)
        {
            throw new Exception("Insufficient Balance");
        }
        else {
            balance -= amount;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}