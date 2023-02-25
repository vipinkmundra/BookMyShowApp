package com.example.BookMyShow.Dto;

import lombok.Data;

@Data
public class TheaterEntryDto {

    //Attribute that is require
    private String location;
    private String name;
    private int classicSeatsCount;
    private int premiumSeatsCount;
}
