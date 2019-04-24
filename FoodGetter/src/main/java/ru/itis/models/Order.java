package ru.itis.models;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Order {
    Long id;
    String from;
    String to;
    Double price;
    Boolean paid;
}
