package com.adepuu.oop.Bank;

public class Bank extends BankAccount
{
    private final String bankName;
    public Bank(String accountNumber, String bankName)
    {
        super(accountNumber);
        this.bankName = bankName;
    }

    public String getBankName() {
        return this.bankName;
    }
}