package com.fivepoint.projet.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Vote implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

	@ManyToOne
    private Subjet subjet;

	@ManyToOne
	private User user;

    private boolean choice;

    private Date date;
}
