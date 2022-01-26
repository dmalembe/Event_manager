package com.entreprise.eventbackend.DTO.request;

import java.util.Date;

import com.entreprise.eventbackend.enumeration.Category;

import lombok.Data;

@Data
public class EventRequest {
	private Long id;
	private String entitled;
	private Date date;
	private Category category;
	private String Adresse;
	private int capacity;
}
