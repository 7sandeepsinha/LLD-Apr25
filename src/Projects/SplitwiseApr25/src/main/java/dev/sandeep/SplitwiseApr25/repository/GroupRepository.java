package dev.sandeep.SplitwiseApr25.repository;

import dev.sandeep.SplitwiseApr25.model.Group;
import dev.sandeep.SplitwiseApr25.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
}
