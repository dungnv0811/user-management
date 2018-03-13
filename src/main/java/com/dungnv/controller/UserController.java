package com.dungnv.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dungnv.collection.User;
import com.dungnv.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		userService.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateUser(@RequestBody User user) {
		User existingEmp = userService.getById(user.getId());
		if (existingEmp == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			userService.save(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") String id) {
		User user = userService.getById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAll();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
		User user = userService.getById(id);
		if (user == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			userService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
}
