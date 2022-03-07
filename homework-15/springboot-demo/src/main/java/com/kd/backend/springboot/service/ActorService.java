package com.kd.backend.springboot.service;

import com.kd.backend.springboot.dto.ActorDTO;
import com.kd.backend.springboot.dto.FilmDTO;

import java.util.List;

public interface ActorService {
    ActorDTO getActorById(Long id);
    List<ActorDTO> getActorsByFirstName(String FirstName);
    ActorDTO createActor(ActorDTO actorDTO);
}
