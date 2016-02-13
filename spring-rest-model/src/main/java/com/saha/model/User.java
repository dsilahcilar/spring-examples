package com.saha.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.dozer.Mapping;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class User implements Serializable {
    private String name;
    private String lastName;
    private String userName;
    @Mapping("id")
    private String tcKimlik;


}
