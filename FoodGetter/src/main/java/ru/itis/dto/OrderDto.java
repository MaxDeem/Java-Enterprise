package ru.itis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.itis.models.Order;
import ru.itis.models.Shop;
import ru.itis.models.User;

@Setter
@Getter
@Builder
public class OrderDto {
    String from; //shopName
    String to; //address
    Double price;
    Boolean paid;

    public static OrderDto from(Order order, Shop shop, User user){
        return OrderDto.builder()
                .from(shop.getName())
                .to(user.getAddress())
                .price(order.getPrice())
                .paid(order.getPaid())
                .build();
    }
}
