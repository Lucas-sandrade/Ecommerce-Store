package br.com.sousa.srv.ecommercestoreapi.domain.exception;

import java.io.Serial;
import java.io.Serializable;

public class BusinessException extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = 4966722711092532439L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
