package com.saha.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 120, unique = true, updatable = true)
    private String userName;

    @Column
    private String name;

    @Column
    private String lastName;

    @OneToOne(fetch = FetchType.LAZY)
    private ProfileEntity profile;

    @OneToMany(mappedBy = "userEntity",
            cascade = {CascadeType.ALL})
    private List<TweetEntity> tweets;

}
