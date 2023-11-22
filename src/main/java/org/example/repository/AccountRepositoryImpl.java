package org.example.repository;

import org.example.director.BankDirector;
import org.example.entity.BankAccount;
import org.example.enums.AccountStatus;
import org.example.enums.AccountType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {
    //Implementation du pattern Singleton
    private static final AccountRepositoryImpl accountRepositoryImpl;
    static {
        System.out.println("Instanciation du Singleton---Singleton instantiation");
        accountRepositoryImpl =new AccountRepositoryImpl();

    }

    private AccountRepositoryImpl(){}

    private long accountsCount=0;
    // Utilisation d'une Map pour stocker les comptes
    private final Map<Long, BankAccount> BankAccountsMap = new HashMap<>();

    @Override
    public BankAccount save(BankAccount account) {
        Long accountId;
        synchronized (this){
            accountId=++accountsCount;//Critical Zone
        }
        account.setAccountId(accountId);
        synchronized (this){
            BankAccountsMap.put(account.getAccountId(), account);
        }

        return account;
    }
    @Override
    public List<BankAccount> findAll() {
        return BankAccountsMap.values().stream().toList();
    }
    @Override
    public Optional<BankAccount> findById(Long accountId) {
        BankAccount bankAccount=BankAccountsMap.get(accountId);
        if(bankAccount==null){
            return Optional.empty();
        }else
            return Optional.of(bankAccount);
    }
    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> predicate) {
        return BankAccountsMap.values().stream().filter(predicate).collect(Collectors.toList());
    }
    @Override
    public BankAccount update(BankAccount account) {
        BankAccountsMap.put(account.getAccountId(),account);
        return account;
    }
    @Override
    public void deleteById(Long id) {
        BankAccountsMap.remove(id);
    }

    public void populate(){
        for (Long i = 0L; i<10; i++){
            BankAccount bankAccount= BankDirector.accountBuilder()
                    .accountId(i)
                    .accountCurrency(Math.random()>0.5?"MAD":"USD")
                    .accountBalance(10000+Math.random()*90000)
                    .accountType(Math.random()>0.5?AccountType.SAVING_ACCOUNT:AccountType.CURRENT_ACCOUNT)
                    .accountStatus(Math.random()>0.5?AccountStatus.CREATED:AccountStatus.ACTIVATED)
                    .build();
            save(bankAccount);
        }
        System.out.println("--------------------------");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Account count= "+accountsCount);
        System.out.println("Size"+BankAccountsMap.values().size());
        System.out.println("--------------------------");
    }

    public static synchronized AccountRepositoryImpl getInstance(){
        return accountRepositoryImpl;
    }

}

