package com.entreprise.eventbackend.mappers;

import org.mapstruct.Mapper;

import com.entreprise.eventbackend.DTO.request.EventRequest;
import com.entreprise.eventbackend.model.Event;

@Mapper(componentModel = "spring")
public interface EventMapper {
	Event eventRequestToEvent(EventRequest eventRequest);
}
