package net.elyaacoubi.mvcspring.repository;

import net.elyaacoubi.mvcspring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Long id(Long id);
}
