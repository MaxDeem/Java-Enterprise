package ru.itis.models;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Order {
    Long id;
    String from;
    String to;
    List<Product> products;
    Double price;
    Boolean paid;
}
