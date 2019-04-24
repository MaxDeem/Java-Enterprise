package ru.itis.models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class ProductType {
    Long id;
    String name;
}
