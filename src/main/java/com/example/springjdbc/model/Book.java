package com.example.springjdbc.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    private String title;
    private String author;
    private Date dateAdded;
}
