package models;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
@Builder
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class ProductOrder {
    Long id;
    List<Product> orderedProducts;
    Double totalPrice;
    String address;
    LocalDate dateTime;
}
