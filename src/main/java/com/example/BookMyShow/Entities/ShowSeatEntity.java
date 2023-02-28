package com.example.BookMyShow.Entities;

import com.example.BookMyShow.Enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "showSeats")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean isBooked;
    private int price;
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private Date bookedAt;

    //this is child wrt to showEntity
    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;

}
