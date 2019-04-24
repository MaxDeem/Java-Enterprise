package ru.itis.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class User {
    Long id;
    String firstName;
    String lastName;
    String address;
    String email;
    String hashPass;
    List<Order> orders;
    Shop shop;
    Status status;
    Long registrationNumber;
}
