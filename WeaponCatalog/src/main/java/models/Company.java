package models;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Company {
    private Long id;
    private String name;
    private Country country;
}
