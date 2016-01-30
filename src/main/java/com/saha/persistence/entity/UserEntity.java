package com.saha.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity extends BaseEntity {

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
    private Set<TweetEntity> tweets;

}
