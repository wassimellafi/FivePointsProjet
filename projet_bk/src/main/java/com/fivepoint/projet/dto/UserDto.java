package com.fivepoint.projet.dto;
import com.fivepoint.projet.model.RoleName;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String email;
    private String password;
    private RoleName role;
    private String firstName;
    private String lastName;


}
