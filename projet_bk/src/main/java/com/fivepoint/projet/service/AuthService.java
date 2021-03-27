package com.fivepoint.projet.service;

import com.fivepoint.projet.dto.UserDto;
import com.fivepoint.projet.model.User;
import com.fivepoint.projet.repository.UserRepo;
import com.fivepoint.projet.security.JwtProvider;
import com.fivepoint.projet.security.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Optional;


@Service
public class AuthService{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtProvider jwtProvider;

    public User getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username="";
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        if(userRepo.findByEmail(username).isPresent()) {
            return userRepo.findByEmail(username).get();
        }
        else{
            return null;
        }
    }

    public User registerUser(@Valid @RequestBody UserDto userr)  {
          Boolean trouve=userRepo.existsByEmail(userr.getEmail()) ;
        if(trouve.equals(true)) {
           return null;
        }
        
        User user=new User();
        user.setEmail(userr.getEmail());
        user.setPassword(encoder.encode(userr.getPassword()));	
        user.setRole(userr.getRole());
        userRepo.save(user);
        return user;
    }


    public JwtResponse authenticateUser(@Valid @RequestBody UserDto user) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()
                );
         Authentication authentication = authenticationManager.authenticate(

                usernamePasswordAuthenticationToken
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities());

    }
}