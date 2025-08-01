package dev.sandeep.BookMyShowApr25.repository;

import dev.sandeep.BookMyShowApr25.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
}
