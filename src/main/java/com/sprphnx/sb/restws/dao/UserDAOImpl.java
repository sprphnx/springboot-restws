package com.sprphnx.sb.restws.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

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

}
