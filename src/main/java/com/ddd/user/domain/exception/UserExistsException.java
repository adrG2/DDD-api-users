package com.ddd.user.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ddd.shared.ConstantsErrors;

@ResponseBody
@ResponseStatus(value = HttpStatus.CONFLICT, reason = ConstantsErrors.USER_ALREADY_EXISTS)
public class UserExistsException extends RuntimeException {

    private static final long serialVersionUID = -7697141101885270697L;

    public UserExistsException() {
	super();
    }

    public UserExistsException(String message, Throwable cause) {
	super(message, cause);
    }

    public UserExistsException(String message) {
	super(message);
    }

    public UserExistsException(Throwable cause) {
	super(cause);
    }

}
