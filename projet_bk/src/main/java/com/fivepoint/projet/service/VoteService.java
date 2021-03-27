package com.fivepoint.projet.service;

import com.fivepoint.projet.model.User;
import com.fivepoint.projet.model.Vote;
import com.fivepoint.projet.repository.VoteRepo;
import com.fivepoint.projet.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class VoteService {

	@Autowired
	private VoteRepo voteRepo;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	private AuthService authService;

	public Vote save(Vote vote) {
		vote.setDate(Calendar.getInstance().getTime());
		User currentUser=authService.getCurrentUser();
		if(currentUser != null) {
			vote.setUser(currentUser);
			Calendar c = Calendar.getInstance();
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MILLISECOND, 0);
			Calendar c1 = Calendar.getInstance();
			c1.set(Calendar.HOUR_OF_DAY, 0);
			c1.set(Calendar.MINUTE, 0);
			c1.set(Calendar.SECOND, 0);
			c1.set(Calendar.MILLISECOND, 0);
			c1.add(Calendar.DAY_OF_MONTH, 1);
			int nbVote = voteRepo.findByUserAndDateBetween(currentUser, c.getTime(), c1.getTime()).size();
			if (nbVote < 5) {
				return voteRepo.save(vote);
			}
		}
		return null;
	}

	public List<Vote> findAll() {
		return voteRepo.findAll();
	}

}
