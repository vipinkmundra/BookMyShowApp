package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.Dto.TheaterEntryDto;
import com.example.BookMyShow.Entities.TheaterEntity;

public class TheaterConvertor {

    public static TheaterEntity converDtoToTheaterEntity(TheaterEntryDto theaterEntryDto){
        TheaterEntity theaterEntity = TheaterEntity.builder().location(theaterEntryDto.getLocation())
                .name(theaterEntryDto.getName()).build();
        return theaterEntity;
    }
}
