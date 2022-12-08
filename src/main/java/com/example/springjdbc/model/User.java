package com.example.springjdbc.model;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Component
@Scope("prototype")
public class User {
    private Integer id;
    private String firstname;
    private String lastname;
    private Date birthday;
    private String phone;
    private String email;
    private String books;
}
