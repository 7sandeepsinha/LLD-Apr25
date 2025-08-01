package dev.sandeep.BookMyShowApr25.repository;

import dev.sandeep.BookMyShowApr25.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
