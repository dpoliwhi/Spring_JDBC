package service;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@Scope("prototype")
public class User {
    private Integer id;
    private String firstname;
    private String lastname;
    private String birthday;
    private String phone;
    private String email;
    private List<Book> books;

}
