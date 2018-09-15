package models;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Weapon {
    private Long id;
    private String name;
    private WeaponType type;
    private Company madeBy;
    private int productionYear;
    private WeaponCharacteristics characteristics;
    private String decription;
    private double price;
}
