package io.github.renatonobrega.auth_api.repository;

import io.github.renatonobrega.auth_api.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
