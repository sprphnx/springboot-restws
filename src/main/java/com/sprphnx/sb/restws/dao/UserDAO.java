package com.sprphnx.sb.restws.dao;

import java.util.List;

import com.sprphnx.sb.restws.model.UserDTO;

public interface UserDAO {

	List<UserDTO> findAll();

	List<UserDTO> findById(Integer id);

}