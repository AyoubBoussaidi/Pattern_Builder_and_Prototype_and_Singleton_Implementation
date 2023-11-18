package org.example.repository;

import org.example.entity.BankAccount;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface AccountRepository {
    BankAccount save(BankAccount account);
    List<BankAccount> findAll();
    Optional<BankAccount> findById(Long accountId);
    List<BankAccount> searchAccounts(Predicate<BankAccount> predicate);
    BankAccount update(BankAccount account);
    void deleteById(Long id);
}

