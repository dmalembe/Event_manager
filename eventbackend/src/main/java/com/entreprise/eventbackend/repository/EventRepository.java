package com.entreprise.eventbackend.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entreprise.eventbackend.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	
	Page<Event> findByEntitled(String title, Pageable pageable);
	
}
