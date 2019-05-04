package ru.itis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.itis.models.Owner;
import ru.itis.models.Shop;

@Setter
@Getter
@Builder
public class ShopDto {
    String name;
    String address;
    String ownerName;
    Long regNum;

    public static ShopDto from(Shop shop, Owner owner){
        return ShopDto.builder()
                .name(shop.getName())
                .address(shop.getAddress())
                .ownerName(owner.getFirstName())
                .regNum(owner.getRegistrationNumber())
                .build();
    }
}
