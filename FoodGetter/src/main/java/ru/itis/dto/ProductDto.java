package ru.itis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.itis.models.Product;

@Setter
@Getter
@Builder
public class ProductDto {
    String name;
    Double price;

    public static ProductDto from(Product product){
        return ProductDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
