package com.ecommerce.handlerException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.ecommerce.dto.response.ExceptionResponseDTO;
import com.ecommerce.exception.EcommerceException;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> defaultHandler(Exception exception) {
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO();
        responseDTO.setTitulo("Hubo un problema con el servidor");
        responseDTO.setMensaje(exception.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
    }

    @ExceptionHandler(EcommerceException.class)
    public ResponseEntity<ExceptionResponseDTO> ecommerceException(EcommerceException exception) {
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO();
        responseDTO.setTitulo(exception.getTitulo());
        responseDTO.setMensaje(exception.getMessage());

        return ResponseEntity.status(exception.getEstado()).body(responseDTO);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionResponseDTO> handleMethodNotSupported(HttpRequestMethodNotSupportedException exception) {
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO();
        responseDTO.setTitulo("Método no permitido");
        responseDTO.setMensaje("El método " + exception.getMethod() + " no está permitido para esta URL.");

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(responseDTO);
    }
}