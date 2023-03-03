package com.gable.runma.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity 
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
public class Runner extends User {
	private String emergencyName;
	private String emergencyPhone;
	private String chronicDisease;
	
	@OneToMany(mappedBy = "runner")
	private List<Ticket> ticket;
}
