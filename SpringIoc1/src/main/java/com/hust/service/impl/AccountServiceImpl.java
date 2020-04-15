package com.hust.service.impl;

import com.hust.dao.IAccountDao;
import com.hust.domain.Account;
import com.hust.service.AccountService;

import java.util.*;

public class AccountServiceImpl implements AccountService {

    private IAccountDao accountDao;


    public AccountServiceImpl(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public void saveAccount(Account account) {
        accountDao.save(account);
    }

    public void updateAccount(Account account) {
        accountDao.update(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.delete(accountId);
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findById(accountId);
    }

    public List<Account> findAllAcoount() {
        return accountDao.findAll();
    }
}
