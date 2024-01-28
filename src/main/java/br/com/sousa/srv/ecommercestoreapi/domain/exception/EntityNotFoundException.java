package br.com.sousa.srv.ecommercestoreapi.domain.exception;

import java.io.Serial;

public abstract class EntityNotFoundException extends BusinessException {
    @Serial
    private static final long serialVersionUID = 4724638191989513600L;

    public EntityNotFoundException(String message) {
        super(message);
    }


}