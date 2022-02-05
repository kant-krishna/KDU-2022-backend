package com.kd.spring.jdbc.service;

import com.kd.spring.jdbc.model.Actor;
import com.kd.spring.jdbc.model.Film;

import java.util.List;
import java.util.Set;

public interface ActorService {
    Actor getActorById(Long id);
    List<Actor> getActorByFirstName(String firstName);
    List<Actor> getActorByLastName(String lastName);
    List<Film> getFilmByActorName(String actorName);
}