package com.example.BookMyShow.Entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String movieName;
    private int totalAmount;
    private LocalDate showDate;
    private LocalTime showTime;
    private String ticketId = UUID.randomUUID().toString();
    private String theaterName;
    private String bookedSeats;

    //This is child wrt to userEntity
    @ManyToOne
    @JoinColumn
    private UserEntity userEntity;

    //This is child wrt to showEntity
    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;


}
