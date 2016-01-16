package com.saha.model;

import lombok.Getter;
import lombok.Setter;
import org.dozer.Mapping;

@Getter
@Setter
public class User {
    private String name;
    private String lastName;
    private String userName;
    @Mapping("id")
    private String tcKimlik;


}
