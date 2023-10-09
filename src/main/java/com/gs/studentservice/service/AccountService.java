package com.gs.studentservice.service;

import com.gs.studentservice.model.Account;
import com.gs.studentservice.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;


    public Account createAccount(Account account) {
        return accountRepo.save(account);
    }

    public List<Account> getAllAccount() {
        return accountRepo.findAll();
    }

    public void deleteAccount(Long id) {
          accountRepo.deleteById(id);
    }

    public Optional<Account> getUserById(Long id) {
        return accountRepo.findById(id);
    }

    public Account updateAccount(Optional<Account> accountById, Account account ) {
        Account currentAccount = accountById.get();
        currentAccount.setPaymentMonth(account.getPaymentMonth());
        currentAccount.setAccount(account.getAccount());
        currentAccount.setTotalDue(account.getTotalDue());
        currentAccount.setBasePayment(account.getBasePayment());
      return  accountRepo.save(currentAccount);
    }
}
