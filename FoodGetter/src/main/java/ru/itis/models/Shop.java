package ru.itis.models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class Shop {
    Long id;
    String name;
    String address;
}
