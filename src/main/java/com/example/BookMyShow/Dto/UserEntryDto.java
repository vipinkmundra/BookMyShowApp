package com.example.BookMyShow.Dto;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class UserEntryDto {

    private String name;
    private String email;
    private String address;

    private String mobNo;
    private int age;
}
