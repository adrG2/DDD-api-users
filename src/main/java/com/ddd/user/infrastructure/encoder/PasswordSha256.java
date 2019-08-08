package com.ddd.user.infrastructure.encoder;

import org.apache.commons.codec.digest.DigestUtils;

import com.ddd.user.domain.PasswordEncoder;

public class PasswordSha256 implements PasswordEncoder {

    @Override
    public String encode(String string) {
	return DigestUtils.sha256Hex(string);
    }

}
