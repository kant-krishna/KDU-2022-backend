package com.kd.backend.springboot.repository;

import com.kd.backend.springboot.entity.Actor;
import com.kd.backend.springboot.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    List<Actor> findByFirstName(String firstName);
}
