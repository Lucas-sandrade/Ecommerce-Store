package br.com.sousa.srv.ecommercestoreapi.domain.exception;

public class ProductsNotFoundException extends BusinessException{

    private static final String MESSAGE = "There's no products registration with id %d.";
    public ProductsNotFoundException(Long id) {
        this(String.format(MESSAGE, id));
    }
    public ProductsNotFoundException(String message) {
        super(message);
    }
}
