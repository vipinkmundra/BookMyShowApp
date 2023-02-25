package com.example.BookMyShow.Service;

import com.example.BookMyShow.Convertors.MovieConvertor;
import com.example.BookMyShow.Dto.MovieEntryDto;
import com.example.BookMyShow.Dto.UserEntryDto;
import com.example.BookMyShow.Entities.MovieEntity;
import com.example.BookMyShow.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDto movieEntryDto) throws Exception{
        MovieEntity movieEntity = MovieConvertor.convertDtoMovieEntity(movieEntryDto);
        movieRepository.save(movieEntity);
        return "Movie added Successfully.";
    }
}
