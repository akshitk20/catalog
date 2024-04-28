package shoppingcart.catalog.model.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class UpdateProductRequest {
    private String id;
    private String name;
    private List<String> category;
    private String description;
    private String imageFile;
    private BigDecimal price;
}
