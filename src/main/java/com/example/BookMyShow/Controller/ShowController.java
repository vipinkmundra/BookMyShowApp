package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Dto.ShowEntryDto;
import com.example.BookMyShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add_show")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto){
        try {
            String response = showService.addShow(showEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception e){
            String result = "show is  not been added.";
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        }
    }
}
