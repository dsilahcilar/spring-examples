package com.saha.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tweets")
@Getter
@Setter
public class TweetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String content;

    @ManyToOne
    private UserEntity userEntity;
}
