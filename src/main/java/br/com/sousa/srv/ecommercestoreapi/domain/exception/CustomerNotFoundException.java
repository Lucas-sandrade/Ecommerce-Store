package br.com.sousa.srv.ecommercestoreapi.domain.exception;

import java.io.Serial;

public class CustomerNotFoundException extends EntityNotFoundException {
    @Serial
    private static final long serialVersionUID = 359788822941435124L;

    private static final String MESSAGE = "There's no customer registration with id %d.";

    public CustomerNotFoundException(Long id) {
        this(String.format(MESSAGE, id));
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
