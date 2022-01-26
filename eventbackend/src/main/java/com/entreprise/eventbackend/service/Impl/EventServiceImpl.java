package com.entreprise.eventbackend.service.Impl;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.entreprise.eventbackend.DTO.request.EventRequest;
import com.entreprise.eventbackend.mappers.EventMapper;
import com.entreprise.eventbackend.model.Event;
import com.entreprise.eventbackend.repository.EventRepository;
import com.entreprise.eventbackend.service.EventService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class EventServiceImpl implements EventService {
	
	private EventRepository eventRepository;
	
	private EventMapper eventMapper;

	@Override
	public Event create(Event event) {
		log.info("Saving new event {}",event.getEntitled());
		return eventRepository.save(event);
	}

	@Override
	public Collection<Event> getEvents() {
		log.info("Fetching all events");
		Collection<Event> EVENTS_LIST = eventRepository.findAll();
		return EVENTS_LIST;
	}

	@Override
	public Event getEventByID(Long id) {
		log.info("Fetching server by ID {}",id);
		return eventRepository.findById(id).get();
	}

	@Override
	public Event update(Long id, EventRequest eventRequest) {
		log.info("Updating event {}", eventRequest.getEntitled());
		Optional<Event> optionalEvent = eventRepository.findById(id);
		if(optionalEvent.isPresent()) {
			return eventRepository.save(eventMapper.eventRequestToEvent(eventRequest));
		}
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		log.info("Deleting event by ID",id);
		eventRepository.deleteById(id);
		return Boolean.TRUE;
	}

	@Override
	public void deleteAll() {
		log.info("Deleting all events");
		eventRepository.deleteAll();
	}

}
