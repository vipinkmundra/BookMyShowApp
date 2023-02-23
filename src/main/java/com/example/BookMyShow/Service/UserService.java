package com.example.BookMyShow.Service;

import com.example.BookMyShow.Dto.UserEntryDto;
import com.example.BookMyShow.Entities.UserEntity;
import com.example.BookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public void addUser(UserEntryDto userEntryDto){
        //need to convert the userEntryDto to user Entity

        //By using builder annotation we can set all the attribute in one go
        UserEntity userEntity = UserEntity.builder().age(userEntryDto.getAge()).mobNo(userEntryDto.getMobNo())
                .email(userEntryDto.getEmail()).address(userEntryDto.getAddress()).name(userEntryDto.getName()).build();

        userRepository.save(userEntity);

    }
}
