package com.saha.model;

import lombok.Getter;
import lombok.Setter;
import org.dozer.Mapping;

@Setter
@Getter
public class Tweet {

    private Long id;

    private String content;

    @Mapping("userEntity.id")
    private Long userId;
}
