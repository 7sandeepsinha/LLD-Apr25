package dev.sandeep.BookMyShowApr25.model;

import dev.sandeep.BookMyShowApr25.model.constant.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "BMS_User")
public class User extends BaseModel{
    private String name;
    private String email;
    private String password;
    private UserRole userRole;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Ticket> tickets;
}
