package com.bobu.testcase.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Parent extends User {

    private String inviteCode;

    public Parent(String email, String password, String passwordMatch, String name, String surname, Role role, String inviteCode) {
        super(email, password, passwordMatch, name, surname, role);
        this.inviteCode = inviteCode;
    }
}
