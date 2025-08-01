package dev.sandeep.BookMyShowApr25.repository;

import dev.sandeep.BookMyShowApr25.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
}
