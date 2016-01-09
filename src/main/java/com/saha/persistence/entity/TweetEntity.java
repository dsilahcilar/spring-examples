package com.saha.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "tweets")
public class TweetEntity {

    @Id
    private Long id;

    private String content;

    @ManyToOne
    private UserEntity userEntity;
}
