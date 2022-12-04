package com.example.springjdbc;

import configuration.MyConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.User;
import service.UserDao;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        UserDao userDao = context.getBean(UserDao.class);
        User user5 = userDao.findById(5);
        System.out.println(user5);
    }
}
