package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.Dto.TicketEntryDto;
import com.example.BookMyShow.Entities.TicketEntity;

public class TicketConvertor {
    public static TicketEntity convertDtoToTicketEntity(TicketEntryDto ticketEntryDto){
        TicketEntity ticketEntity =  new TicketEntity();
        return ticketEntity;
    }
}
