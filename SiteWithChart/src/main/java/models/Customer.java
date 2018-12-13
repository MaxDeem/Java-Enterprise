package models;

import lombok.*;

import java.util.ArrayList;

@Builder
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Customer {
    Long id;
    String first_name;
    String last_name;
    String email;
    String hash_password;
    ArrayList<Product> products;
}
