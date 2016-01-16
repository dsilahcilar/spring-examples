package com.saha.annotations;

import org.springframework.context.annotation.Profile;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Profile("test")
@Retention(RetentionPolicy.RUNTIME)
public @interface TestProfile {
}
