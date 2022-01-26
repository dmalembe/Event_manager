package com.entreprise.eventbackend.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.entreprise.eventbackend.enumeration.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "entitled")
	private String entitled;
	
	@Column(name = "date")
	private Date date;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@Column(name = "adresse")
	private String Adresse;
	
	@Column(name = "capacity")
	private int capacity;
	
}
