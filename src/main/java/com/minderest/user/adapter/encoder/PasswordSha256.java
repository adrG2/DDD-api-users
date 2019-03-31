package com.minderest.user.adapter.encoder;

import org.apache.commons.codec.digest.DigestUtils;

import com.minderest.user.domain.port.PasswordEncoder;

public class PasswordSha256 implements PasswordEncoder {

    @Override
    public String encode(String string) {
	return DigestUtils.sha256Hex(string);
    }

}
