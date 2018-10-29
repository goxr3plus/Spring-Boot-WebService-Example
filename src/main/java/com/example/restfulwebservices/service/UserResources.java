package com.example.restfulwebservices.service;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.restfulwebservices.exceptions.UserNotFoundException;
import com.example.restfulwebservices.manager.UserDaoService;
import com.example.restfulwebservices.model.User;

@RestController
public class UserResources {

	@Autowired
	UserDaoService userDaoService;

	@GetMapping("/users")
	public List<User> getUsers() {
		return userDaoService.getUsers();
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		User user = userDaoService.find(id);
		if (user == null)
			throw new UserNotFoundException("User Not Found");

		// HATEOAS
		//Resource<User> user = new Resource<User>(user);
		//ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());

		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User usr = userDaoService.save(user);

		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usr.getId()).toUri();

		return ResponseEntity.created(loc).build();
	}

	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable int id) {
		User user = userDaoService.deleteById(id);

		if (user == null)
			throw new UserNotFoundException("id-" + id);

		/*
		 * URI loc =
		 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
		 * (user.getId()).toUri();
		 * 
		 * 
		 * 
		 * return ResponseEntity.created(loc).build();
		 */
		return "wow";
	}

}
