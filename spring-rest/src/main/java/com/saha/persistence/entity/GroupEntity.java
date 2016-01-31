package com.saha.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class GroupEntity {

    @Id
    private Long id;

    private String title;

    @ManyToMany
    private List<UserEntity> userEntityList;
}
