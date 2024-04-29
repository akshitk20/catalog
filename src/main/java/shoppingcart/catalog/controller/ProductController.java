package shoppingcart.catalog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shoppingcart.catalog.model.Product;
import shoppingcart.catalog.model.request.CreateProductRequest;
import shoppingcart.catalog.model.request.UpdateProductRequest;
import shoppingcart.catalog.model.response.CreateProductResponse;
import shoppingcart.catalog.model.response.UpdateProductResponse;
import shoppingcart.catalog.service.ProductService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest createProductRequest) {
        CreateProductResponse response = productService.createProduct(createProductRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateProductResponse> updateProduct(@RequestBody UpdateProductRequest updateProductRequest) {
        return ResponseEntity.ok(productService.updateProductRequest(updateProductRequest));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }
}
