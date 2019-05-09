package ru.itis.models;

import lombok.*;

import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
public class Owner{
    Long id;
    String firstName;
    String lastName;
    String address;
    String email;
    String hashPass;
    Status status;
    Long registrationNumber;
    Shop shop;
}



