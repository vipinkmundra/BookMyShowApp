package com.example.BookMyShow.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@Builder // this annotation always required all args constructor and this will help to create the entity in faster way from dto
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true,nullable = false)
    private String email;
    private String address;
    @Column(unique = true)
    @NonNull
    private String mobNo;
    private int age;

    //This is parent wrt ot ticket
    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL)
    List<TicketEntity> BookedTickets = new ArrayList<>();

}
