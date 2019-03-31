package com.minderest.user.infrastructure.idgenerator;

import java.util.UUID;

import com.minderest.user.domain.IdGenerate;

public class Uuid implements IdGenerate {

    @Override
    public String generate() {
	return UUID.randomUUID().toString();
    }

}
