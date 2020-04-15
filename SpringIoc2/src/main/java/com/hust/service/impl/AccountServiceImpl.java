package com.hust.service.impl;

import com.hust.dao.IAccountDao;
import com.hust.domain.Account;
import com.hust.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/*
 等同 <bean id = “”  class="">
*  Controller 一般用于表现层
*  Service 一般用于业务层
*  Repository 一般用于持久层
 value =  id ，可不写，默认为驼峰法的名称
* */
@Component("accountService")
public class AccountServiceImpl implements AccountService {


    /*
    * 注入属性  等同<property name="" value=""></property>
    *  Autowired按照属性自动注入 set方法可以省略 当有多个类型匹配时 注入对象变量名为Bean id
    *  Qualifier 在自动注入的基础上，再按照Bean注入，不能单独使用要和Autowired配合使用 value为指定id
    *  Resource 直接按照Bean id注入 name:指定bean id
    *   Value value 注入 基本数据类型或String
    * */
    @Autowired
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
