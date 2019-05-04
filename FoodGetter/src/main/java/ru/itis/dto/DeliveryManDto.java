package ru.itis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.itis.models.DeliveryMan;

@Getter
@Setter
@Builder
public class DeliveryManDto {
    String firstName;
    String lastName;
    String email;
    String address;

    public static DeliveryManDto from(DeliveryMan deliveryMan){
        return DeliveryManDto.builder()
                .firstName(deliveryMan.getFirstName())
                .lastName(deliveryMan.getLastName())
                .email(deliveryMan.getLastName())
                .address(deliveryMan.getAddress())
                .build();
    }
}
