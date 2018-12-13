package models;

import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class SomeOrder {
    private Long id;
    private List<Weapon> weapons;
    private String address;
    private String note;
}
