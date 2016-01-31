package com.saha.persistence.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date sonDegistirilme;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getSonDegistirilme() {
        return sonDegistirilme;
    }

    public void setSonDegistirilme(Date sonDegistirilme) {
        this.sonDegistirilme = sonDegistirilme;
    }
}
