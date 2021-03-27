package com.fivepoint.projet.service;

import com.fivepoint.projet.model.Subjet;
import com.fivepoint.projet.repository.SubjetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SubjetService {

	@Autowired
	private SubjetRepo subjetRepo;

	public Subjet save(Subjet subjet) {
		return subjetRepo.save(subjet);
	}

	public List<Subjet> findAll() {
		return subjetRepo.findAll();
	}

}
