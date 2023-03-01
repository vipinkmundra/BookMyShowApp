package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Dto.TicketEntryDto;
import com.example.BookMyShow.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping("/add_ticket")
    public ResponseEntity<String> bookTicket(@RequestBody TicketEntryDto ticketEntryDto){
        try {
            String response = ticketService.bookTicket(ticketEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception e){
            String result = "Ticket is not booked. Try Again.";
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        }
    }

}
