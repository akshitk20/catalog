package shoppingcart.catalog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import shoppingcart.catalog.model.Product;

import java.util.UUID;

public interface ProductRepository extends MongoRepository<Product, UUID> {

}
