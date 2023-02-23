package com.example.BookMyShow.Entities;

import com.example.BookMyShow.Enums.SeatType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "theater_seats")
@NoArgsConstructor
public class TheaterSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private int seatNo;

    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;


}
