package com.practice.controller;

import com.practice.model.UserDO;
import com.practice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDO>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@PostMapping()
	public ResponseEntity createUser(@RequestBody UserDO userDO){
		userService.createUser(userDO);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@DeleteMapping(value = "{uuid}")
	public ResponseEntity deleteUser(@PathVariable UUID uuid){
		userService.deleteUser(uuid);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
