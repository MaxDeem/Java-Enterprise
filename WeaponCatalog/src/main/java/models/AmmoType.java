package models;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class AmmoType {
    private Long id;
    private String type;
}
