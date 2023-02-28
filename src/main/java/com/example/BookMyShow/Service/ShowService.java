package com.example.BookMyShow.Service;

import com.example.BookMyShow.Convertors.ShowConvertor;
import com.example.BookMyShow.Dto.ShowEntryDto;
import com.example.BookMyShow.Entities.*;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Repository.TheaterRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    MovieRepository movieRepository;

    public String addShow(ShowEntryDto showEntryDto){
        ShowEntity showEntity = ShowConvertor.convertDtoToShowEntity(showEntryDto);

        int theaterId = showEntryDto.getTheaterId();
        int movieId = showEntryDto.getMovieId();

        //setting the attribute of foriegn key
        TheaterEntity theaterEntity = theaterRepository.findById(theaterId).get();
        MovieEntity movieEntity = movieRepository.findById(movieId).get();

        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);

        List<ShowSeatEntity> showSeatEntityList = createShowSeatEntity(showEntryDto,showEntity);
        showEntity.setListOfShowSeats(showSeatEntityList);

        //Now we  also need to update the parent entities
        List<ShowEntity> showEntityList = movieEntity.getShowList();
        showEntityList.add(showEntity);
        movieEntity.setShowList(showEntityList);

        movieRepository.save(movieEntity);

        List<ShowEntity> showEntityList1 = theaterEntity.getShowEntityList();
        showEntityList1.add(showEntity);
        theaterEntity.setShowEntityList(showEntityList1);

        theaterRepository.save(theaterEntity);

        return "The show is added successfully.";
    }

    public List<ShowSeatEntity> createShowSeatEntity(ShowEntryDto showEntryDto,ShowEntity showEntity){
        TheaterEntity theaterEntity = showEntity.getTheaterEntity();
        List<TheaterSeatEntity> theaterSeatEntitiyList = theaterEntity.getTheaterSeatEntitiyList();

        List<ShowSeatEntity> showSeatEntityList = new ArrayList<>();

        for(TheaterSeatEntity theaterSeatEntity : theaterSeatEntitiyList){
            ShowSeatEntity showSeatEntity = new ShowSeatEntity();

            showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theaterSeatEntity.getSeatType());

            if(theaterSeatEntity.getSeatType().equals(SeatType.CLASSIC)){
                showSeatEntity.setPrice(showEntryDto.getClassicSeatPrice());
            }else{
                showSeatEntity.setPrice(showEntryDto.getPremiumSeatPrice());
            }

            showSeatEntity.setBooked(false);
            showSeatEntity.setShowEntity(showEntity); //parent : foreign key for the showSeat Entity

            showSeatEntityList.add(showSeatEntity);
        }
        return showSeatEntityList;
    }
}
