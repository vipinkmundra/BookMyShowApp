package com.example.BookMyShow.Dto;

import com.example.BookMyShow.Enums.ShowType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
@Data
public class ShowEntryDto {

    private LocalDate showDate;
    private LocalTime showTime;
    private ShowType showType;
    private int movieId;
    private int theaterId;
    private int classicSeatPrice;
    private int premiumSeatPrice;



}
