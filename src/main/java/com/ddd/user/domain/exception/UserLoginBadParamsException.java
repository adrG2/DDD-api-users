package com.ddd.user.domain.exception;

import com.ddd.shared.ConstantsErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = ConstantsErrors.BAD_PARAMS)
public class UserLoginBadParamsException extends RuntimeException {

    private static final long serialVersionUID = 7202654486373289808L;

    public UserLoginBadParamsException() {
        super();
    }

    public UserLoginBadParamsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLoginBadParamsException(String message) {
        super(message);
    }

    public UserLoginBadParamsException(Throwable cause) {
        super(cause);
    }
}
