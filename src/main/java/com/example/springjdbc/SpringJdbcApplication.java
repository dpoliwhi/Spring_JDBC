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
        User user6 = userDao.findByPhone("8-923-705-4446");
        User user4 = userDao.findById(4);

        System.out.println(user6);
        System.out.println(user4);

    }
}
