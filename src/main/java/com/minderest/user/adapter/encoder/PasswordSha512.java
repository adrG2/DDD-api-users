package com.minderest.user.adapter.encoder;

import org.apache.commons.codec.digest.DigestUtils;

import com.minderest.user.domain.port.PasswordEncoder;

public class PasswordSha512 implements PasswordEncoder {

    @Override
    public String encode(String string) {
	return DigestUtils.sha512Hex(string);
    }

}
