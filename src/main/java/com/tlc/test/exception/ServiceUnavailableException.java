package com.tlc.test.exception;

import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.tlc.test.response.ResponseCode;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceUnavailableException extends ExceptionBase {
    public ServiceUnavailableException(Logger l) {
        logger = l;
        errorCode = ResponseCode.SERVICE_UNAVAIABLE;
    }
    public ServiceUnavailableException(Logger l, @Nullable String message) {
        logger = l;
        errorCode = ResponseCode.SERVICE_UNAVAIABLE;
        this.additionalMessage = message;
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.SERVICE_UNAVAILABLE.value();
    }
}
