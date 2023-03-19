package com.br.calcme.models.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
@Setter
public class User {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private long id;
    private String name;
    private String email;
    private String phone;

    private User(long id,
                 String name,
                 String email,
                 String phone){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public static User build(long id,
                      String name,
                      String email,
                      String phone){
        return new User(id, name, email, phone);
    }
}
