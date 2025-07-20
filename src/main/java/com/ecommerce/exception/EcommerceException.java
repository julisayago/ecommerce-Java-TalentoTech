package com.ecommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EcommerceException extends RuntimeException{
    protected String titulo;
    protected HttpStatus estado;

    public EcommerceException(String titulo, String mensaje, HttpStatus estado){
        super(mensaje);
        this.titulo = titulo;
        this.estado = estado;
    }
}