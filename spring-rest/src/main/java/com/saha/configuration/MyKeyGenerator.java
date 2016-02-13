package com.saha.configuration;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

public class MyKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        StringBuilder sb = new StringBuilder();
        sb.append(target.getClass().getSimpleName())
                .append(".")
                .append(method.getName());
        for (Object obj : params) {
            sb.append(".")
                    .append(obj.toString());
        }
        return sb.toString();
    }
}
