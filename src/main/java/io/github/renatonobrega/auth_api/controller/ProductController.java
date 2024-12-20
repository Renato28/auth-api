package io.github.renatonobrega.auth_api.controller;

import io.github.renatonobrega.auth_api.domain.product.Product;
import io.github.renatonobrega.auth_api.domain.product.ProductRequestDTO;
import io.github.renatonobrega.auth_api.domain.product.ProductResponseDTO;
import io.github.renatonobrega.auth_api.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid ProductRequestDTO data) {
        Product newProduct = new Product(data);

        this.productRepository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity listar() {
        List<ProductResponseDTO> listaProdutos = this.productRepository.findAll().stream().map(ProductResponseDTO::new).toList();

        return ResponseEntity.ok(listaProdutos);
    }
}
