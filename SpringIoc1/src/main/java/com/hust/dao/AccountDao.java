package com.hust.dao;

import com.hust.domain.Account;
import com.hust.service.AccountService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.*;

public class AccountDao implements IAccountDao{
    private String name;
    private Integer age;
    private Date birthday;

    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMaps;
    private Properties myProps;


    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMaps(Map<String, String> myMaps) {
        this.myMaps = myMaps;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void save(float money) {
        System.out.println(name+","+age+","+birthday+":"+money);
    }

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", myStrs=" + Arrays.toString(myStrs) +
                ", myList=" + myList +
                ", mySet=" + mySet +
                ", myMaps=" + myMaps +
                ", myProps=" + myProps +
                '}';
    }

    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }



    public void save(Account account) {
        try {
            runner.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Account account) {
        try {
            runner.update("update account set name = ? , money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer accountId) {
        try {
            runner.update("delete from account where id = ?",accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account findById(Integer accountId) {
        try {
            return runner.query("select * from account where id = ?",new BeanHandler<Account>(Account.class),accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Account> findAll() {
        try {
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
