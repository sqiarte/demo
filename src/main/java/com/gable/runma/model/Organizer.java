package com.gable.runma.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;


@Data
@Entity
@JsonIdentityInfo (
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")

public class Organizer {
	@Id 
	@GeneratedValue
	private Integer id;
	private String name;
	private String contact;
	private String website;
	private String facebook;
	private String email;
	
	
//	@JsonIgnore
	@ManyToMany(mappedBy = "organizerList")
	private List<Event> eventList;

}
