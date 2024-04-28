package shoppingcart.catalog.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateProductResponse {
    private boolean isSuccess;
}
