package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.Dto.MovieEntryDto;
import com.example.BookMyShow.Entities.MovieEntity;

public class MovieConvertor {

    public static MovieEntity convertDtoMovieEntity(MovieEntryDto movieEntryDto){
        MovieEntity movieEntity = MovieEntity.builder().movieName(movieEntryDto.getMovieName())
                .genre(movieEntryDto.getGenre()).duration(movieEntryDto.getDuration())
                .rating(movieEntryDto.getRating()).language(movieEntryDto.getLanguage()).build();
        return movieEntity;
    }
}
