package com.wellsfargo.SBA3.its.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.SBA3.its.dao.UsersRepository;
import com.wellsfargo.SBA3.its.entity.Users;
import com.wellsfargo.SBA3.its.exceptions.UserException;

@Service
public class UsersServiceImp implements UsersService{
	
	@Autowired
	private UsersRepository userRepo;
	
	@Override
	@Transactional
	public Users add(Users user) throws UserException {
		if(user!=null) {
			if(userRepo.existsById(user.getUserId())) {
				throw new UserException("Interview ID already exists");
			}
			
			userRepo.save(user);
		}
		return user;
	}

	@Override
	public boolean deleteUser(int userId) throws UserException {
		if(!userRepo.existsById(userId)) {
			throw new UserException("User Not Found");
		}
	
		userRepo.deleteById(userId);
		return true;
	}

	@Override
	public List<Users> getAllUsers() throws UserException {
		return userRepo.findAll();
	}

	@Override
	public Users getUserById(int userId) throws UserException {
		return userRepo.findById(userId).orElse(null);	
	}
}
