package br.com.wesley.teste3wings.service;

import br.com.wesley.teste3wings.dto.ProductDto;
import br.com.wesley.teste3wings.exception.AppException;
import br.com.wesley.teste3wings.model.Category;
import br.com.wesley.teste3wings.model.Product;
import br.com.wesley.teste3wings.repository.CategoryRepository;
import br.com.wesley.teste3wings.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product createProduct(final ProductDto productData) {
        final Category foundCategory = categoryRepository.findById(productData.getCategory_id()).orElseThrow(() -> new AppException("Category not found!", HttpStatus.NOT_FOUND));

        final Product newProduct = new Product(foundCategory, productData.getName(), productData.getBrand(), productData.getDescription(), productData.getWhenToTake(), productData.getPhotoUrl(), productData.getPrice());


        return productRepository.save(newProduct);
    }

    public List<Product> readProducts() {
        return productRepository.findAll();
    }

    public Product retrieveProduct(final long id) {
        return productRepository.findById(id).orElseThrow(() -> new AppException("Product not found!", HttpStatus.NOT_FOUND));
    }

    public Product updateProduct(final ProductDto productData, final long id) {
        final Product foundProduct = productRepository.findById(id).orElseThrow(() -> new AppException("Product not found!", HttpStatus.NOT_FOUND));
        final Category foundCategory = categoryRepository.findById(productData.getCategory_id()).orElseThrow(() -> new AppException("Category not found!", HttpStatus.NOT_FOUND));

        foundProduct.setBrand(productData.getBrand());
        foundProduct.setName(productData.getName());
        foundProduct.setDescription(productData.getDescription());
        foundProduct.setPrice(productData.getPrice());
        foundProduct.setPhotoUrl(productData.getPhotoUrl());
        foundProduct.setWhenToTake(productData.getWhenToTake());
        foundProduct.setCategory(foundCategory);

        return productRepository.save(foundProduct);
    }

    public void deleteProduct(final long id) {
        final Product foundProduct = productRepository.findById(id).orElseThrow(() -> new AppException("Product not found!", HttpStatus.NOT_FOUND));

        productRepository.delete(foundProduct);
    }
}
