package com.example.springjdbc;

import com.example.springjdbc.configuration.MyConfiguration;
import com.example.springjdbc.dao.BookDao;
import com.example.springjdbc.mapper.BookMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.springjdbc.model.User;
import com.example.springjdbc.dao.UserDao;
import org.springframework.context.annotation.Import;

import java.sql.Date;

@SpringBootApplication
@Import({UserDao.class, BookDao.class, User.class, BookMapper.class})
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        UserDao userDao = context.getBean(UserDao.class);

        User user1 = new User(1,
                "Евгений",
                "Поноарев",
                Date.valueOf("2000-03-17"),
                "8-923-705-4446",
                "ornare.in@yahoo.net",
                "Старик и море, 1984");
        userDao.createUser(user1);

        User user2 = new User(2,
                "Игорь",
                "Ревякин",
                Date.valueOf("2006-06-18"),
                "8-999-775-4444",
                "eu.augue@yahoo.org",
                "Фиеста, Скотный двор");
        userDao.createUser(user2);

        User user3 = new User(3,
                "Алексей",
                "Демидов",
                Date.valueOf("2016-04-08"),
                "8-922-222-2121",
                "in.scelerisque.scelerisque@aol.edu",
                "Крестный отец, Шантарам, 1984, Старик и море");
        userDao.createUser(user3);

        System.out.println(userDao.getBooksOfUserByPhone("8-923-705-4446"));
        System.out.println(userDao.getBooksOfUserByEmail("in.scelerisque.scelerisque@aol.edu"));

    }
}
