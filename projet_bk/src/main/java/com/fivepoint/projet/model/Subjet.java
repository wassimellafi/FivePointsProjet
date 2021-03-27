package com.fivepoint.projet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
public class Subjet implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String title;
    private String description;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="subjet")
    @JsonIgnoreProperties({"subjet","user"})
    List<Vote> voteList =new ArrayList<>();

}
