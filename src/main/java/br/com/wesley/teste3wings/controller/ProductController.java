package br.com.wesley.teste3wings.controller;

import br.com.wesley.teste3wings.dto.ProductDto;
import br.com.wesley.teste3wings.model.Product;
import br.com.wesley.teste3wings.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody final ProductDto productData) {
        final Product createdProduct = productService.createProduct(productData);

        return new ResponseEntity<Product>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> readProducts() {
        final List<Product> allProducts = productService.readProducts();

        return new ResponseEntity<List<Product>>(allProducts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> retrieveProduct(@PathVariable String id) {
        final Product product = productService.retrieveProduct(Long.parseLong(id));

        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody final ProductDto productData, @PathVariable String id) {
        final Product updatedProduct = productService.updateProduct(productData, Long.parseLong(id));

        return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(Long.parseLong(id));

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
