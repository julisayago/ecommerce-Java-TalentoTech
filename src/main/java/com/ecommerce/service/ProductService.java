package com.ecommerce.service;

import com.ecommerce.exception.ProductoNoEncontradoException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.ecommerce.dto.request.ProductRequestDTO;
import com.ecommerce.dto.response.ProductResponseDTO;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductResponseDTO crearProducto(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productRequestDTO, product);

        this.repository.save(product);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        BeanUtils.copyProperties(product, productResponseDTO);
        return productResponseDTO;
    }

    private ProductResponseDTO convertirADTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        BeanUtils.copyProperties(product, dto);
        return dto;
    }

    public List<ProductResponseDTO> obtenerProductos() {
        List<Product> productos = this.repository.findAll();
        List<ProductResponseDTO> dtos = new ArrayList<>();

        for (Product producto : productos) {
            ProductResponseDTO dto = convertirADTO(producto);
            dtos.add(dto);
        }

        return dtos;
    }

    public ProductResponseDTO buscarProductosPorId(Long id) {
        Product product = this.repository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));

        return this.convertirADTO(product);
    }

    public ProductResponseDTO actualizarProducto(Long id, ProductRequestDTO productRequestDTO) {
        Product product = this.repository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
        BeanUtils.copyProperties(productRequestDTO, product);

        this.repository.save(product);

        return this.convertirADTO(product);
    }

    public ProductResponseDTO eliminarProducto(Long id) {
        Product product = this.repository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
        this.repository.delete(product);

        return this.convertirADTO(product);
    }


}