package com.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.dto.request.ProductRequestDTO;
import com.ecommerce.dto.response.ProductResponseDTO;
import com.ecommerce.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/productos")

public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDTO crearProducto(@RequestBody ProductRequestDTO requestDTO) {
        return service.crearProducto(requestDTO);
    }

    @GetMapping("")
    public List<ProductResponseDTO> obtenerProductos() {
        return this.service.obtenerProductos();
    }

    @GetMapping("/{id}")
    public ProductResponseDTO buscarProductosPorId(@PathVariable Long id) {
        return this.service.buscarProductosPorId(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDTO actualizarProducto(@PathVariable Long id,
                                                 @RequestBody ProductRequestDTO requestDTO) {
        return this.service.actualizarProducto(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public ProductResponseDTO eliminarProducto(@PathVariable Long id) {
        return this.service.eliminarProducto(id);
    }
}