package com.entreprise.eventbackend.controller;

import static org.springframework.http.HttpStatus.OK;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entreprise.eventbackend.DTO.response.Response;
import com.entreprise.eventbackend.model.Event;
import com.entreprise.eventbackend.service.EventService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author dmalembe
 *
 */
@Controller
@RequestMapping(path = "/events")
@RequiredArgsConstructor
public class EventController {
	
	private final EventService eventService;
	
	/**
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	@GetMapping(path = "/")
	public ResponseEntity<Response> getEvents(){

		Collection<Event> EVENTS = eventService.getEvents();
		
	    
		
		return ResponseEntity.ok(
				Response.builder()
				.timeStamp(LocalDateTime.now())
				.data(Map.of("Events", EVENTS))
				.message("events retrieved")
				.status(OK)
				.statusCode(OK.value())
				.build()
				);
	}
	

}
