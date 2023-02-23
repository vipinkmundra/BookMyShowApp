package com.example.BookMyShow.Entities;

import com.example.BookMyShow.Enums.ShowType;
import jdk.jfr.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "shows")
@NoArgsConstructor
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;
    private LocalTime showTime;
    @Enumerated(value = EnumType.STRING)
    private ShowType showType;
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;

    //The showEntity is child wrt to MovieEntity
    @ManyToOne
    @JoinColumn
    private MovieEntity movieEntity;

    //showEntity is parent wrt to theaterEntity
    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;

    //Show is parent wrt to TicketEntity
    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    List<TicketEntity> listOfBookedTicketsForShow = new ArrayList<>();

    //this is parent wrt to showSeatEntity
    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    List<TicketEntity> listOfShowSeats = new ArrayList<>();

}
