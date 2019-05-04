package ru.itis.models;

import lombok.*;


@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
public class DeliveryMan {
    Long id;
    String firstName;
    String lastName;
    String address;
    String email;
    String hashPass;
    Status status;
}

