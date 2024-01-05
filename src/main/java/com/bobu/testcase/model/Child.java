package com.bobu.testcase.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Child extends User{


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn,
            inverseJoinColumns = @JoinColumn)
    private List<Parent> parentList;

    public Child(String email, String password, String passwordMatch, String name, String surname, Role role, List<Parent> parentList) {
        super(email, password, passwordMatch, name, surname, role);
        this.parentList = parentList;
    }

    public Child(String email, String password, String passwordMatch, String name, String surname, Role role) {
        super(email, password, passwordMatch, name, surname, role);
    }
}
