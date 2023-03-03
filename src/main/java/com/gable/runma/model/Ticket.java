package com.gable.runma.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data 
@Entity
public class Ticket {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private Status status;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date paidDate;
	
	@ManyToOne
	private Runner runner;
	
	@ManyToOne
	private RaceType raceType;

}
