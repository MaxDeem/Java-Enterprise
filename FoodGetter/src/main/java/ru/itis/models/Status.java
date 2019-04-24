package ru.itis.models;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@ToString
public class Status {
    Long id;
    String name;
}
