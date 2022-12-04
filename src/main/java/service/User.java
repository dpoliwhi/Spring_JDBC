package service;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String firstname;
    private String lastname;
    private String birthday;
    private String phone;
    private String email;
}
