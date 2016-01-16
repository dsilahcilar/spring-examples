package com.saha.persistence.entity;

import lombok.Data;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;
import java.util.List;

@Entity(name = "dummies")
@Table
@Data
@SequenceGenerator(name = "dami_seq", sequenceName = "dami_seq", initialValue = 1, allocationSize = 10)
public class DummyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dami_seq")
    private Long id;

    private String description;

    @Column(updatable = false)
    private String updatable;

    @Column(insertable = false)
    private String insertable;

}
