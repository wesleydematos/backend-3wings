package br.com.wesley.teste3wings.repository;

import br.com.wesley.teste3wings.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
