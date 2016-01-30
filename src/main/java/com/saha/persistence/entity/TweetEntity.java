package com.saha.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

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

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date sonDegistirilme;

}
