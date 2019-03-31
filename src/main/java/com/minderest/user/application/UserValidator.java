package com.minderest.user.application;

import java.util.Objects;

import com.minderest.shared.ConstantsErrors;
import com.minderest.shared.util.StringCheck;
import com.minderest.user.domain.User;
import com.minderest.user.domain.exception.UserValidationException;

public class UserValidator {

    private UserValidator() {
	throw new AssertionError(ConstantsErrors.NOT_ALLOWED_INSTANTIATE);
    }

    public static void validate(User user) {

	if (Objects.isNull(user)) {
	    throw new UserValidationException(ConstantsErrors.USER_NULL);
	}

	if (StringCheck.isBlankAnyArgument(user.getEmail(), user.getFirstName(), user.getLastName())) {
	    throw new UserValidationException(ConstantsErrors.USER_NOT_VALIDATE);
	}

    }

}
