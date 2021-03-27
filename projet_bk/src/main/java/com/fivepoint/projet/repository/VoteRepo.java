package com.fivepoint.projet.repository;

import com.fivepoint.projet.model.User;
import com.fivepoint.projet.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VoteRepo extends JpaRepository<Vote,Long> {


    List<Vote> findByUserAndDateBetween(User user, Date begin, Date end);
}
