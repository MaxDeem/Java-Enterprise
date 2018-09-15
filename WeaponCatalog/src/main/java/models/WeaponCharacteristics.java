package models;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class WeaponCharacteristics {
    private double weight;
    private double length;
    private double fireRate;
    private double firingRange;
    private Ammunition ammo;
}
