package com.gable.runma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Entity 
@Inheritance(strategy = InheritanceType.SINGLE_TABLE )
@Data
public class Admin extends User {
	private String permission;
}
