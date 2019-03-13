package com.sprphnx.sb.restws.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprphnx.sb.restws.dao.UserDAO;
import com.sprphnx.sb.restws.exception.UserNotFoundException;
import com.sprphnx.sb.restws.model.UserDTO;



@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserDAO userDAO;

	@GetMapping("/")
	public List<UserDTO> findAll() {
		return userDAO.findAll();
	}

	@GetMapping("/{id}")
	public List<UserDTO> findById(@PathVariable Integer id) {
		List<UserDTO> response = userDAO.findById(id);
		// Best practice return proper user not found exception.
		if (response == null || response.size() == 0) {
			throw new UserNotFoundException("id - " + id + " not found",
					"Requested user not found, verify the user id");
		}
		return response;
	}

	@PostMapping("/")
	public Resource<UserDTO> save(@Valid @RequestBody UserDTO user) {
		userDAO.save(user);
		// Best practice is to return created status with the uri as below
		// with out hateoas
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		Resource<UserDTO> resource = new Resource<UserDTO>(user);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findById(user.getId()));
		
		resource.add(linkTo.withRel("URI"));
		//with out hateoas
		//return ResponseEntity.created(uri).build();
		
		return resource;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		UserDTO user = userDAO.delete(id);
		if (user == null) {
			throw new UserNotFoundException("id - " + id + " not found",
					"Requested user not found, verify the user id");
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}
}
