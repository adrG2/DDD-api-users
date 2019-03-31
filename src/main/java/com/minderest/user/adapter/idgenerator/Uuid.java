package com.minderest.user.adapter.idgenerator;

import java.util.UUID;

import com.minderest.user.domain.port.IdGenerate;

public class Uuid implements IdGenerate {

    @Override
    public String generate() {
	return UUID.randomUUID().toString();
    }

}
