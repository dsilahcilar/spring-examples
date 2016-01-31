package com.saha.annotations;

import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Profile("prod")
@Retention(RetentionPolicy.RUNTIME)
public @interface ProdProfile {
}
