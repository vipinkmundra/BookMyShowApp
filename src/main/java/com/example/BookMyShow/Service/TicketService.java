package com.example.BookMyShow.Service;

import com.example.BookMyShow.Convertors.TicketConvertor;
import com.example.BookMyShow.Dto.TicketEntryDto;
import com.example.BookMyShow.Entities.ShowEntity;
import com.example.BookMyShow.Entities.ShowSeatEntity;
import com.example.BookMyShow.Entities.TicketEntity;
import com.example.BookMyShow.Entities.UserEntity;
import com.example.BookMyShow.Repository.ShowRepository;
import com.example.BookMyShow.Repository.TicketRepository;
import com.example.BookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;
    public String bookTicket(TicketEntryDto ticketEntryDto) throws Exception {
        //1. Create TicketEntity from entryDto : Convert DTO ---> Entity
        TicketEntity ticketEntity = TicketConvertor.convertDtoToTicketEntity(ticketEntryDto);

        //Validation : Check if the requested seats are available or not ?
        boolean isValidRequest = checkValidityOfRequestedSeats(ticketEntryDto);
        if(isValidRequest == false){
            throw new Exception("Requested Sets is not Available.");
        }

        //We assume that the requestedSeats are valid
        ShowEntity showEntity = showRepository.findById(ticketEntryDto.getShowId()).get();
        List<ShowSeatEntity> seatEntityList = showEntity.getListOfShowSeats();
        List<String> requestSeats = ticketEntryDto.getRequestedSeats();

        int totalAmount = 0;
        for (ShowSeatEntity showSeatEntity : seatEntityList){
            if (requestSeats.contains(showSeatEntity.getSeatNo())){
                totalAmount = totalAmount + showSeatEntity.getPrice();
                showSeatEntity.setBooked(true);
                showSeatEntity.setBookedAt(new Date());
            }
        }
        ticketEntity.setTotalAmount(totalAmount);

        //Setting the other attributes for the ticketEntity
        ticketEntity.setMovieName(showEntity.getMovieEntity().getMovieName());
        ticketEntity.setTheaterName(showEntity.getTheaterEntity().getName());
        ticketEntity.setShowDate(showEntity.getShowDate());
        ticketEntity.setShowTime(showEntity.getShowTime());

        //We need to set that string that talked about requested Seats
        String allocatedSeats = getAllocatedSeatsFromShowSeats(requestSeats);
        ticketEntity.setBookedSeats(allocatedSeats);

        //Setting the foreign key attributes
        UserEntity userEntity = userRepository.findById(ticketEntryDto.getUserId()).get();
        ticketEntity.setUserEntity(userEntity);
        ticketEntity.setShowEntity(showEntity);

        //Save the parent
//        ticketEntity = ticketRepository.save(ticketEntity); need to check

        List<TicketEntity> ticketEntityList = showEntity.getListOfBookedTicketsForShow();
        ticketEntityList.add(ticketEntity);
        showEntity.setListOfBookedTicketsForShow(ticketEntityList);
        showRepository.save(showEntity);

        List<TicketEntity> ticketEntityList1 = userEntity.getBookedTickets();
        ticketEntityList1.add(ticketEntity);
        userEntity.setBookedTickets(ticketEntityList1);
        userRepository.save(userEntity);

        return "Ticket has successfully been added";
    }

    private boolean checkValidityOfRequestedSeats(TicketEntryDto ticketEntryDto){
        int showId = ticketEntryDto.getShowId();
        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();
        ShowEntity showEntity = showRepository.findById(showId).get();

        List<ShowSeatEntity> lisOfSeats = showEntity.getListOfShowSeats();

        //Iterating over the list Of Seats for that particular show
        for(ShowSeatEntity showSeatEntity : lisOfSeats){
            String seatNo = showSeatEntity.getSeatNo();

            if (requestedSeats.contains(seatNo)){
                    if (showSeatEntity.isBooked() == true){
                        return false;
                    }
            }
        }
        //All the seats requested were available
        return true;
    }

    private String getAllocatedSeatsFromShowSeats(List<String> requestSeats){
        String result = "";
        for (String seats : requestSeats){
            result = result + seats + ", ";
        }
        return result;
    }
}
