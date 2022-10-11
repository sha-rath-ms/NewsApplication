package com.example.NewsApplicationUsers.repository.table;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class UsersTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Size(min = 4)
    private String password;
    @Column(name = "email")
    private String emailId;

    public UsersTable(String firstName, String lastName, String password, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailId = emailId;
    }

    public UsersTable(String password, String emailId) {
        this.password = password;
        this.emailId = emailId;
    }

}
