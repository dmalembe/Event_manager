package com.entreprise.eventbackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entreprise.eventbackend.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
