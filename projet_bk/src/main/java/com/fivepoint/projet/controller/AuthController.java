package com.fivepoint.projet.controller;

import com.fivepoint.projet.dto.UserDto;
import com.fivepoint.projet.model.RoleName;
import com.fivepoint.projet.model.User;
import com.fivepoint.projet.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity register(@Valid @RequestBody UserDto userDto) {

		userDto.setRole(RoleName.ROLE_USER);

		User user = authService.registerUser(userDto);
		if (user == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		} else {
				return new ResponseEntity(userDto, HttpStatus.OK);

		}
	}


	@PostMapping("/signin")
	public ResponseEntity authenticateUser(@Valid @RequestBody UserDto user) {
		return ResponseEntity.ok().body(authService.authenticateUser(user));
	}
}