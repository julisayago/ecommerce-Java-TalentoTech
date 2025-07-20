package com.ecommerce.exception;

import org.springframework.http.HttpStatus;

public class ProductoNoEncontradoException extends EcommerceException {

    public ProductoNoEncontradoException(Long id) {
        super(
                "Producto no encontrado",
                "No se encontró ningún producto con ID: " + id,
                HttpStatus.NOT_FOUND
        );
    }
}
