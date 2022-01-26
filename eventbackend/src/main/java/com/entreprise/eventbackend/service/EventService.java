package com.entreprise.eventbackend.service;

import java.util.Collection;

import com.entreprise.eventbackend.DTO.request.EventRequest;
import com.entreprise.eventbackend.model.Event;

public interface EventService {

	Event create(Event event);
	Collection<Event> getEvents();
	Event getEventByID(Long id);
	Event update(Long id,EventRequest eventRequest);
	Boolean delete(Long id);
	void deleteAll();
}
