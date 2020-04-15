package com.hust.service;

import com.hust.domain.Account;

import java.util.List;

public interface AccountService {
    public void saveAccount(Account account);

    public void updateAccount(Account account);

    public void deleteAccount(Integer accountId);

    public Account findAccountById(Integer accountId);

    public List<Account> findAllAcoount();
}
