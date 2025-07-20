package com.ecommerce.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {

    private Long id;
    private String nombre;
    private Double precio;
    private Integer stock;
    private String description;
    private String imagen;
}