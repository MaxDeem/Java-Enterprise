package ru.itis.models;

import lombok.*;


import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "system_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String address;
    String email;
    String hashPass;
    @ManyToOne
    Status status;
    @OneToMany(mappedBy = "user")
    List<Order> orders;
}
