package dev.sandeep.BookMyShowApr25.service;

import dev.sandeep.BookMyShowApr25.exception.TheatreNotFoundException;
import dev.sandeep.BookMyShowApr25.model.Theatre;
import dev.sandeep.BookMyShowApr25.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    public Theatre createTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public Theatre getTheatreById(int id) {
        return theatreRepository.findById(id).orElseThrow(
                () -> new TheatreNotFoundException("Theatre with id " + id + " not found")
        );
    }

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public void deleteTheatreById(int id) {
        theatreRepository.deleteById(id);
    }
}
