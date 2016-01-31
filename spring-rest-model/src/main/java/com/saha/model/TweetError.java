package com.saha.model;

import lombok.Data;

@Data
public class TweetError {
    private String description;
    private Long code;
}
