package ru.itis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.itis.models.User;

@Setter
@Getter
@Builder
public class UserDto {
    String firstName;
    String lastName;
    String email;
    String address;

    public static UserDto from(User user){
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .address(user.getAddress())
                .build();
    }
}
