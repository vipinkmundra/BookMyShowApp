package com.example.BookMyShow.Service;

import com.example.BookMyShow.Controller.UserController;
import com.example.BookMyShow.Convertors.UserConvertor;
import com.example.BookMyShow.Dto.UserEntryDto;
import com.example.BookMyShow.Entities.UserEntity;
import com.example.BookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public String addUser(UserEntryDto userEntryDto) throws Exception,NullPointerException{
        UserEntity userEntity = UserConvertor.convertDtoUserEntity(userEntryDto);
        return "User added Successfully.";
    }


}
