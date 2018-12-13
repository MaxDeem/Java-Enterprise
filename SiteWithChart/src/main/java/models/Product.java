package models;

import lombok.*;

@Builder
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Product {
    Long id;
    String name;
    Double price;
}
