package dev.sandeep.BookMyShowApr25.repository;

import dev.sandeep.BookMyShowApr25.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
