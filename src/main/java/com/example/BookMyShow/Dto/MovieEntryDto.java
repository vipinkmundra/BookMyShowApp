package com.example.BookMyShow.Dto;

import com.example.BookMyShow.Enums.Genre;
import com.example.BookMyShow.Enums.Language;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Data
public class MovieEntryDto {
    private String movieName;
    private double rating;
    private int duration;
    private Genre genre;
    private Language language;

}
