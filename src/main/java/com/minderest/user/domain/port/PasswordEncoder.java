package com.minderest.user.domain.port;

public interface PasswordEncoder {
    String encode(String string);
}
