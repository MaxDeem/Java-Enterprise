package models;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Ammunition {
    private Long id;
    private String caliber;
    private AmmoType type;
}
