package com.bobu.testcase.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Subscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private SubscribeType subscribeType;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private User user;

    public Subscribe(SubscribeType subscribeType, User user) {
        this.subscribeType = subscribeType;
        this.user = user;
    }
}
