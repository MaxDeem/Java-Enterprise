package models;

import lombok.*;

import java.util.List;
import java.util.Map;
@Builder
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Shop {
    Long id;
    String name;
    List<Product> stock;
}
