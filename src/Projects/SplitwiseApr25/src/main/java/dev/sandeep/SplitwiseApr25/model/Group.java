package dev.sandeep.SplitwiseApr25.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "SW_GROUP")
public class Group extends BaseModel {
    private String name;
    @ManyToOne
    private User admin;
    @ManyToMany
    private List<User> members;
    @OneToMany
    @JoinColumn(name = "group_id")
    private List<Expense> expenses;
}
/*
    Group - Admin
        User - Group -> 1:M
        1       M
        1       1

        Group - User -> M:1

    Group - Member
        User - Group -> M:M
        1       M
        M       1
 */