package com.ddd.user.infrastructure.idgenerator;

import java.util.UUID;

import com.ddd.user.domain.IdGenerate;

public class Uuid implements IdGenerate {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
