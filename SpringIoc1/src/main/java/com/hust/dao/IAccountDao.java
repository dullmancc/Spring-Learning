package com.hust.dao;

import com.hust.domain.Account;

import java.util.List;

public interface IAccountDao {
    void save(Account account);

    void update(Account account);

    void delete(Integer accountId);

    Account findById(Integer accountId);

    List<Account> findAll();
}
