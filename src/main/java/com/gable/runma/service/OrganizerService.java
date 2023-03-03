package com.gable.runma.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gable.runma.model.Event;
import com.gable.runma.model.Organizer;
import com.gable.runma.repository.EventRepository;
import com.gable.runma.repository.OrganizerRepository;

@Service
public class OrganizerService {
	@Autowired
	private OrganizerRepository repo;
	@Autowired
	private EventRepository evtRepo;

	public List<Organizer> findAll() {
		return repo.findAll();
	}
	
	public Organizer newOrganizer(Organizer org) {
		return repo.save(org);
	}
	
	// org = newValue
	// obj = old
	public Organizer updateOrganizer(Organizer org) {
		Organizer obj = repo.findById(org.getId()).orElseThrow();
		
		obj.setContact(org.getContact());
		obj.setEmail(org.getEmail());
		obj.setFacebook(org.getFacebook());
		obj.setName(org.getName());
		obj.setWebsite(org.getWebsite());
		
//		List<Event> events = org.getEventList();
		if (org != null) {
		obj.getEventList().clear();
		if(org.getEventList() !=null){
		for (Event event : org.getEventList()) {
			Event objEvent = evtRepo.findById(event.getId()).orElseThrow();
			obj.getEventList().add(objEvent);
			if (! objEvent.getOrganizerList().contains(obj)) {
				objEvent.getOrganizerList().add(obj);
				evtRepo.save(objEvent);
			}
		}
		}
		}
		repo.save(obj);
		return obj;
	}
}
