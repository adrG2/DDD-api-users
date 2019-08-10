package com.ddd.user.domain.exception;

import com.ddd.shared.ConstantsErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = ConstantsErrors.FORBIDDEN_LOGGED)
public class ForbiddenException extends RuntimeException {

    private static final long serialVersionUID = -4593675784407260900L;

    public ForbiddenException() {
        super();
    }

    public ForbiddenException(String message) {
        super(message);
    }
}
