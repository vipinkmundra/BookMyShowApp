package com.example.BookMyShow.Service;

import com.example.BookMyShow.Convertors.TheaterConvertor;
import com.example.BookMyShow.Dto.TheaterEntryDto;
import com.example.BookMyShow.Entities.TheaterEntity;
import com.example.BookMyShow.Entities.TheaterSeatEntity;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Repository.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TheaterService {

    @Autowired
    TheaterSeatRepository theaterSeatRepository;


    public String addTheater(TheaterEntryDto theaterEntryDto) throws Exception{
        //Create theater seats
        //I need to save the theater and i need the theater entity
        //Always set the attribute before the saving
        TheaterEntity theaterEntity = TheaterConvertor.converDtoToTheaterEntity(theaterEntryDto);
        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeats(theaterEntryDto,theaterEntity);

        return "theater added Successfully.";
    }

    public List<TheaterSeatEntity> createTheaterSeats(TheaterEntryDto theaterEntryDto,  TheaterEntity theaterEntity){
        int noClassicSeats = theaterEntryDto.getClassicSeatsCount();
        int noPremiumSeats = theaterEntryDto.getPremiumSeatsCount();
        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();

        for(int count=1;count<=noClassicSeats;count++){
            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder().seatType(SeatType.CLASSIC)
                    .seatNo(count+"C").build();
            theaterSeatEntityList.add(theaterSeatEntity);
        }

        for(int count=1;count<=noPremiumSeats;count++){
            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder().seatType(SeatType.PREMIUM)
                    .seatNo(count+"P").build();
            theaterSeatEntityList.add(theaterSeatEntity);
        }
        theaterSeatRepository.saveAll(theaterSeatEntityList);

        return theaterSeatEntityList;
    }
}
