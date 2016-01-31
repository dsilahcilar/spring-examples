package com.saha.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class ProfileEntity {

    @Id
    private Long id;

    private String profilePictureUrl;


}
