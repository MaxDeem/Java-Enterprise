package models;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class WeaponType {
    private Long id;
    private String type;
}
