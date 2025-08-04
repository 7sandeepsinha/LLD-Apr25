package dev.sandeep.BookMyShowApr25.service;

import dev.sandeep.BookMyShowApr25.exception.ShowNotFoundException;
import dev.sandeep.BookMyShowApr25.model.Seat;
import dev.sandeep.BookMyShowApr25.model.Show;
import dev.sandeep.BookMyShowApr25.model.ShowSeat;
import dev.sandeep.BookMyShowApr25.model.constant.ShowSeatStatus;
import dev.sandeep.BookMyShowApr25.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatService showSeatService;

    public Show createShow(Show show) {
        //create the showSeats for the show
        List<ShowSeat> showSeats = new ArrayList<>();
        show = showRepository.save(show);

        List<Seat> seats = show.getAuditorium().getSeats();
        for (Seat seat : seats) {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeat(seat);
            showSeat.setPrice(100);
            showSeat.setShow(show); // mapping from ShowSeat -> Show
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
            showSeat = showSeatService.createShowSeat(showSeat);
            showSeats.add(showSeat);
        }
        show.setShowSeats(showSeats); // mapping from Show -> all ShowSeats
        return showRepository.save(show);
    }

    public Show getShowById(int id) {
        return showRepository.findById(id).orElseThrow(
                () -> new ShowNotFoundException("Show with id " + id + " not found")
        );
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public void deleteShowById(int id) {
        showRepository.deleteById(id);
    }
}
