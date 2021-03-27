package com.fivepoint.projet.controller;


import com.fivepoint.projet.model.Subjet;
import com.fivepoint.projet.service.SubjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sujet")
@CrossOrigin
public class SubjetController {
	@Autowired
	private SubjetService subjetService;

	@GetMapping("")
	public List<Subjet> findAll() {
		return subjetService.findAll();
	}

	@PostMapping("")
	public Subjet save(@RequestBody Subjet subjetRepo) {
		return subjetService.save(subjetRepo);
	}
}