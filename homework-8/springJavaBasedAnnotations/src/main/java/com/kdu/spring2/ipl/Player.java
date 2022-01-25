package com.kdu.spring2.ipl;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class Player {
    @NotEmpty(message = "Player Name should not be empty")
    String name;
    LocalDate dateOfBirth;
    @NotNull(message = "Team Name can't be null")
    String teamName;
    public Player() {
    }

    // => NO NEED OF THESE AFTER INSERTING GETTER AND SETTER ANNOTATION

//    public void setDateOfBirth(LocalDate dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public LocalDate getLocalDate() {
//        return dateOfBirth;
//    }
//
    public Optional<@Past LocalDate> getDateOfBirth() {
        return Optional.of(dateOfBirth);
    }
//
//    public String getTeamName() {
//        return teamName;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setTeamName(String teamName) {
//        this.teamName = teamName;
//    }
    @Override
    public String toString() {
        return "Player{" +
                "PlayerName='" + name + '\'' + "Date of Birth:" + dateOfBirth +
                '}';
    }
}
