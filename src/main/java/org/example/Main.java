package org.example;

import org.example.entity.BankAccount;

import org.example.enums.AccountStatus;
import org.example.repository.AccountRepositoryImpl;
import org.example.util.JsonSerializer;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonSerializer<BankAccount> bankAccountJsonSerializer=new JsonSerializer<>();
        AccountRepositoryImpl bankAccountrepository=AccountRepositoryImpl.getInstance();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                bankAccountrepository.populate();
            }).start();
        }
        System.out.println("Tape a character : ");
        System.in.read();

        bankAccountrepository.populate();
        List<BankAccount> bankAccounts=bankAccountrepository.findAll();
        bankAccounts.stream()
                .map(account -> bankAccountJsonSerializer.toJson(account))
                .forEach(System.out::println);






        /*
        System.out.println("===================");
        BankAccount account = bankAccountrepository.findById(1L).orElse(null);

        if(account!=null){
            System.out.println(bankAccountJsonSerializer.toJson(account));
        }*/
    }
}