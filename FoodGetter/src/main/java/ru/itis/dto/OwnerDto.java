package ru.itis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.itis.models.Owner;

@Setter
@Getter
@Builder
public class OwnerDto {
    String firstName;
    String lastName;
    String email;
    String address;
    Long registrationNumber;

    public static OwnerDto from(Owner owner){
        return OwnerDto.builder()
                .firstName(owner.getFirstName())
                .lastName(owner.getLastName())
                .email(owner.getEmail())
                .address(owner.getAddress())
                .registrationNumber(owner.getRegistrationNumber())
                .build();
    }
}
