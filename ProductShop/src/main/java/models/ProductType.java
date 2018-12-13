package models;

import lombok.*;

@Builder
@Getter
@EqualsAndHashCode
@Setter
@ToString
public class ProductType {
    Long id;
    String kind;
}
