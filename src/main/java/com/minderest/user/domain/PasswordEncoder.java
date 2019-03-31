package com.minderest.user.domain;

public interface PasswordEncoder {
    String encode(String string);
}
