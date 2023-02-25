package com.example.BookMyShow.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "theaters")
@Builder
@AllArgsConstructor
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String location;
    private String name;

    //theaterEntity is parent wrt to theaterSeat
    @OneToMany(mappedBy = "theaterEntity",cascade = CascadeType.ALL)
    List<TheaterSeatEntity> theaterSeatEntitiyList = new ArrayList<>();

    //theaterEntity is parent wrt to show
    @OneToMany(mappedBy = "theaterEntity",cascade = CascadeType.ALL)
    List<ShowEntity> showEntityList = new ArrayList<>();
}
