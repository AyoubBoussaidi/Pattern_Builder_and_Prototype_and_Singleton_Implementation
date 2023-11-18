package org.example.director;

import org.example.entity.BankAccount;

public class BankDirector {
    //l'interet de cette classe est de creer plusieurs builders par exemple accountBuilder, customerBuilder
    public static BankAccount.AccountBuilder accountBuilder(){
        return new BankAccount.AccountBuilder();
    }
}
