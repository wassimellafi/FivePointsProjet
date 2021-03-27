package com.fivepoint.projet.repository;


import com.fivepoint.projet.model.Subjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubjetRepo extends JpaRepository<Subjet,Long> {
    
    
}
