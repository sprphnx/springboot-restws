package com.sprphnx.sb.restws.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.sprphnx.sb.restws.exception.UserNotFoundException;
import com.sprphnx.sb.restws.model.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	List<UserDTO> users = new ArrayList<>();

	public UserDAOImpl() {
		users.add(new UserDTO(1, "Rohan", new Date()));
		users.add(new UserDTO(2, "Ramya", new Date()));
		users.add(new UserDTO(3, "Nayana", new Date()));
		users.add(new UserDTO(4, "Roshni", new Date()));

	}

	@Override
	public List<UserDTO> findAll() {
		return users;
	}

	@Override
	public List<UserDTO> findById(final Integer id) {
		return users.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
	}

	@Override
	public void save(UserDTO user) {
		users.add(new UserDTO(user.getId(), user.getName(), user.getDateOfBirth()));
		
	}

	@Override
	public UserDTO delete(final Integer id) {
		UserDTO user = null;
		try {
			user = users.stream().filter(x->x.getId()==id).findFirst().get();
			users.remove(user);
		} catch (NoSuchElementException e) {
			throw new UserNotFoundException("id - " + id + " not found",
					"Requested user not found, verify the user id");
		}
		return user;
	}

}
