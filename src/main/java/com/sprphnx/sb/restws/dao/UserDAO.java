package com.sprphnx.sb.restws.dao;

import java.util.List;

import com.sprphnx.sb.restws.model.UserDTO;

public interface UserDAO {

	public List<UserDTO> findAll();

	public List<UserDTO> findById(Integer id);

	public void save(UserDTO user);

	public UserDTO delete(Integer id);

}