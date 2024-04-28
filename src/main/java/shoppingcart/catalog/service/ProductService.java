package shoppingcart.catalog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shoppingcart.catalog.model.Product;
import shoppingcart.catalog.model.request.CreateProductRequest;
import shoppingcart.catalog.model.response.CreateProductResponse;
import shoppingcart.catalog.repository.ProductRepository;

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
                .name(createProductRequest.getName())
                .category(createProductRequest.getCategory())
                .description(createProductRequest.getDescription())
                .imageFile(createProductRequest.getImageFile())
                .price(createProductRequest.getPrice())
                .build();
    }
}
