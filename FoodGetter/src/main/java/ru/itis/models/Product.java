package ru.itis.models;

import lombok.*;

@Setter
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Product {
    Long id;
    String name;
    Double price;
    Shop shop;
    ProductType type;
}
