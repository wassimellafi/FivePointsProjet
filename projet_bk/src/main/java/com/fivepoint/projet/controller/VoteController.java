package com.fivepoint.projet.controller;

import com.fivepoint.projet.model.Vote;
import com.fivepoint.projet.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vote")
@CrossOrigin
public class VoteController {
	@Autowired
	private VoteService voteService;

	@GetMapping("")
	public List<Vote> findAll() {
		return voteService.findAll();
	}

	@PostMapping("")
	public Vote save(@RequestBody Vote voteRepo) {
		return voteService.save(voteRepo);
	}
}