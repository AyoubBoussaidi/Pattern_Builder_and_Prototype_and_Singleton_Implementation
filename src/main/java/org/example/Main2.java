package org.example;

import org.example.entity.BankAccount;
import org.example.entity.Customer;
import org.example.enums.AccountStatus;
import org.example.enums.AccountType;

public class Main2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        BankAccount account1=new BankAccount();
        account1.setAccountId(1L);
        account1.setBalance(9000);
        account1.setAccountStatus(AccountStatus.CREATED);
        account1.setAccountType(AccountType.CURRENT_ACCOUNT);
        account1.setCurrency("MAD");
        account1.setCustomer(new Customer(1L,"Ayoub"));
        BankAccount account2=account1.clone();
        System.out.println(account1);
        System.out.println(account2);
        account1.getCustomer().setName("Yassine");
        System.out.println("After modification");
        System.out.println(account1);
        System.out.println(account2);

    }
}
