package dev.sandeep.BookMyShowApr25.repository;

import dev.sandeep.BookMyShowApr25.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
