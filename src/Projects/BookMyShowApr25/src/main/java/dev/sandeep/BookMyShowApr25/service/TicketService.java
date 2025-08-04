package dev.sandeep.BookMyShowApr25.service;

import dev.sandeep.BookMyShowApr25.exception.SelectedSeatsNotAvailableException;
import dev.sandeep.BookMyShowApr25.model.ShowSeat;
import dev.sandeep.BookMyShowApr25.model.Ticket;
import dev.sandeep.BookMyShowApr25.model.User;
import dev.sandeep.BookMyShowApr25.model.constant.ShowSeatStatus;
import dev.sandeep.BookMyShowApr25.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ShowSeatService showSeatService;
    @Autowired
    private ShowService showService;

    public Ticket createTicket(int userId, List<Integer> showSeatIds) {
        User user = userService.getUserById(userId);
        int totalCost = 0;
        //TODO: validate the count of seats selected, it should be <10

        //TODO: payment initiation logic
        // assuming payment passed successfully

        List<ShowSeat> showSeats = checkAndLockSeats(showSeatIds);
        for(ShowSeat seat: showSeats) {
            totalCost += seat.getPrice();
        }

        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setShowSeats(showSeats);
        ticket.setTotalCost(totalCost);
        ticket = ticketRepository.save(ticket);

        for(ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
            showSeatService.updateShowSeat(showSeat);
        }

        return ticket;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<ShowSeat> checkAndLockSeats(List<Integer> showSeatIds) {
        List<ShowSeat> showSeats = new ArrayList<>();
        for(int showSeatId : showSeatIds) {
            ShowSeat showSeat = showSeatService.getShowSeatById(showSeatId);
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SelectedSeatsNotAvailableException("Please try booking");
            }
            showSeats.add(showSeat);
        }
        for(ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatService.updateShowSeat(showSeat);
        }
        return showSeats;
    }
}
