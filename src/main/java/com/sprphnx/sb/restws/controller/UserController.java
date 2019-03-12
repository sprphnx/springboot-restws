package com.sprphnx.sb.restws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprphnx.sb.restws.dao.UserDAO;
import com.sprphnx.sb.restws.exception.UserServiceException;
import com.sprphnx.sb.restws.model.UserDTO;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserDAO userDAO;
	
	@GetMapping("/")
	public List<UserDTO> findAll(){
		return userDAO.findAll();
	}
	
	@GetMapping("/{id}")
	public List<UserDTO> findAll(@PathVariable Integer id){
		List<UserDTO> response = userDAO.findById(id);
		if(response == null || response.size() == 0) {
			throw new UserServiceException("id - "+ id+ " not found");
		}
		return response;
	}
	
}
