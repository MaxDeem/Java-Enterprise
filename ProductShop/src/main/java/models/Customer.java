package models;

import lombok.*;

@Builder
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Customer {
    Long id;
    String firstName;
    String lastName;
    String email;
    String hashPassword;
    ProductOrder order;
}
