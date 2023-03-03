package com.gable.runma.model;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
//@JsonIdentityInfo(
//		generator = ObjectIdGenerators.PropertyGenerator.class,
//		property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Event {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String location;
	
	private String tag;
	
	@Temporal(TemporalType.DATE)
	private Date raceDate;
	@Temporal(TemporalType.DATE)
	private Date openRegisDate;
	@Temporal(TemporalType.DATE)
	private Date closeRegisDate;
	

	//cascade คือถ้าลบแม่ ลูกจะตายไปด้วย
	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<RaceType> raceTypeList;
	
	@ManyToMany
	@JoinTable(name = "Event_ORGANIZER", joinColumns = @JoinColumn(name = "event_id") , 
	inverseJoinColumns = @JoinColumn(name= "organizer_id"))
		
	private List<Organizer> organizerList;

}
