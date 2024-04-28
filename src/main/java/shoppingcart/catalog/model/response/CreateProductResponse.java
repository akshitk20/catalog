package shoppingcart.catalog.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CreateProductResponse {
    private UUID id;
}
