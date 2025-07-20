package com.ecommerce.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {

    private String nombre;
    private Double precio;
    private Integer stock;
    private String description;
    private String imagen;
}