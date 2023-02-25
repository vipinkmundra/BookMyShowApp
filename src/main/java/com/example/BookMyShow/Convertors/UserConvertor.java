package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.Dto.UserEntryDto;
import com.example.BookMyShow.Entities.UserEntity;

public class UserConvertor {

    //Static is used to avoid calling via instances/objects
    public static UserEntity convertDtoUserEntity(UserEntryDto userEntryDto){
        //need to convert the userEntryDto to user Entity

        //By using builder annotation we can set all the attribute in one go
        UserEntity userEntity = UserEntity.builder().age(userEntryDto.getAge()).mobNo(userEntryDto.getMobNo())
                .email(userEntryDto.getEmail()).address(userEntryDto.getAddress()).name(userEntryDto.getName()).build();

        return userEntity;
    }
}
