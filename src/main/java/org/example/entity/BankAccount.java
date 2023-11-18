package org.example.entity;

import org.example.enums.AccountStatus;
import org.example.enums.AccountType;

public class BankAccount {
    private Long accountId;private double balance;private String currency;private AccountType accountType;private AccountStatus accountStatus;

    public BankAccount(Long accountId, double balance, String currency, AccountType accountType, AccountStatus accountStatus) {
        this.accountId = accountId;
        this.balance = balance;
        this.currency = currency;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
    }

    public BankAccount() {
    }
    public Long getAccountId() {
        return accountId;
    }
    public double getBalance() {
        return balance;
    }
    public String getCurrency() {
        return currency;
    }
    public AccountType getAccountType() {
        return accountType;
    }
    public AccountStatus getAccountStatus() {
        return accountStatus;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", accountType=" + accountType +
                ", accountStatus=" + accountStatus +
                '}';
    }

    //maintenant cette methode est optionnelle
    public static AccountBuilder builder(){
        return new AccountBuilder();
    }

    public static class AccountBuilder{
        private BankAccount bankAccount=new BankAccount();
        public AccountBuilder accountId(Long id){
            bankAccount.accountId=id;
            return this;
        }
        public AccountBuilder accountType(AccountType type){
            bankAccount.accountType=type;
            return this;
        }
        public AccountBuilder accountCurrency(String currency){
            bankAccount.currency=currency;
            return this;
        }
        public AccountBuilder accountStatus(AccountStatus status){
            bankAccount.accountStatus=status;
            return this;
        }
        public AccountBuilder accountBalance(double balance){
            bankAccount.balance=balance;
            return this;
        }
        public BankAccount build(){
            return  this.bankAccount;
        }

    }
}
