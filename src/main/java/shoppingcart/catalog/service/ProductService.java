package shoppingcart.catalog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shoppingcart.catalog.model.Product;
import shoppingcart.catalog.model.request.CreateProductRequest;
import shoppingcart.catalog.model.request.UpdateProductRequest;
import shoppingcart.catalog.model.response.CreateProductResponse;
import shoppingcart.catalog.model.response.UpdateProductResponse;
import shoppingcart.catalog.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public CreateProductResponse createProduct(CreateProductRequest createProductRequest) {
        Product product = mapRequestToProduct(createProductRequest);
        Product persistedProduct = productRepository.save(product);
        return CreateProductResponse.builder()
                .id(persistedProduct.getId())
                .build();
    }

    private Product mapRequestToProduct(CreateProductRequest createProductRequest) {
        return Product.builder()
                .id(UUID.randomUUID())
                .name(createProductRequest.getName())
                .category(createProductRequest.getCategory())
                .description(createProductRequest.getDescription())
                .imageFile(createProductRequest.getImageFile())
                .price(createProductRequest.getPrice())
                .build();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No product exists by that Id"));
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public UpdateProductResponse updateProductRequest(UpdateProductRequest updateProductRequest) {

        Product product = productRepository.findById(UUID.fromString(updateProductRequest.getId()))
                .orElseThrow(() -> new RuntimeException("No product exists by that Id"));
        product.setCategory(updateProductRequest.getCategory());
        product.setName(updateProductRequest.getName());
        product.setPrice(updateProductRequest.getPrice());
        product.setDescription(updateProductRequest.getDescription());
        product.setImageFile(updateProductRequest.getImageFile());
        productRepository.save(product);
        return UpdateProductResponse.builder()
                .isSuccess(true)
                .build();
    }
}
