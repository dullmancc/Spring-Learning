package com.hust.test;

import com.hust.domain.Account;
import com.hust.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestIOC {
    @Test
    public void testDataSource(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountServiceImpl");
        AccountService accountService1 = (AccountService) ac.getBean("accountServiceImpl");

        System.out.println(accountService);
        System.out.println(accountService1);
        Account cc = new Account();
        cc.setName("caocheng");
        cc.setMoney(1000f);

        accountService.saveAccount(cc);
        System.out.println(accountService1.findAccountById(3));
    }

    @Test
    public void testFindAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountServiceImpl");

        List<Account> accountList = accountService.findAllAcoount();

        for (Account s:accountList
             ) {
            System.out.println(s);
        }
    }

    @Test
    public void testFindOne(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountServiceImpl");

        System.out.println(accountService.findAccountById(1));
    }

    @Test
    public void testDelete(){
        System.out.println("==========before delete===========");
        testFindAll();

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountServiceImpl");

        accountService.deleteAccount(1);

        System.out.println("==========after delete===========");
        testFindAll();
    }


    @Test
    public void testUpdate(){
        System.out.println("==========before update===========");

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountServiceImpl");

        Account ac1 = accountService.findAccountById(2);
        System.out.println(ac1);

        ac1.setName("update");
        ac1.setMoney(1000f);

        accountService.updateAccount(ac1);

        System.out.println("==========after update===========");
        ac1 = accountService.findAccountById(2);
        System.out.println(ac1);

    }
}
