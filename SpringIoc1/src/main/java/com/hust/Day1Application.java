package com.hust;

import com.hust.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Day1Application {
    public static void main(String[] args) {

        /*
        ClassPathXmlApplicationContext 从类根路径下加载配置文件
        FileSystemXmlApplicationContext 从磁盘路径上加载配置文件，配置文件可以在磁盘任何位置
        AnnotationConfigApplicationContext 当我们使用注解配置容器对象是，需要使用这个找到spring容器类,读取注解
        * */
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        AccountService accountService = (AccountService) ac.getBean("accountServiceImpl");
        AccountService accountService1 = (AccountService) ac.getBean("accountServiceImpl");

        System.out.println(accountService);
        System.out.println(accountService1);
    }
}
