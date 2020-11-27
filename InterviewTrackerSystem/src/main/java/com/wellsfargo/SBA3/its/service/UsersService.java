package com.wellsfargo.SBA3.its.service;

import java.util.List;

import com.wellsfargo.SBA3.its.entity.Users;
import com.wellsfargo.SBA3.its.exceptions.UserException;

public interface UsersService {

	Users add(Users user) throws UserException;

	boolean deleteUser(int userId) throws UserException;

	Users getUserById(int userId) throws UserException;

	List<Users> getAllUsers() throws UserException;
}
