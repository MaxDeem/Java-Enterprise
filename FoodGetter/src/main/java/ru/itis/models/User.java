package ru.itis.models;

import lombok.*;


import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@Entity
@Table(name = "system_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    String address;
    String email;
    @Column(name = "hash_pass")
    String hashPass;
    @OneToOne(mappedBy = "status")
    Status status;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Order> orders;
    public User() {
    }
}
