package com.minderest.unit.util;

import com.minderest.shared.ConstantsErrors;

public final class UserFields {

    public static final String NICK_NAME = "anfer90";
    public static final String EMAIL = "anfer@gmail.com";
    public static final String LAST_NAME = "Fernandez";
    public static final String FIRST_NAME = "Antonio";

    private UserFields() {
	throw new AssertionError(ConstantsErrors.NOT_ALLOWED_INSTANTIATE);
    }

}
