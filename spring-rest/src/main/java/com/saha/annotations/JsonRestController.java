package com.saha.annotations;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonRestController {
}
