package com.wellsfargo.SBA3.its.controller;

import java.util.List
;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.SBA3.its.entity.Users;
import com.wellsfargo.SBA3.its.exceptions.UserException;
import com.wellsfargo.SBA3.its.service.UsersService;


@RestController
@RequestMapping("/users")

public class UsersRestController {
	
	  @Autowired private UsersService usersService;
		
		@GetMapping
		public ResponseEntity<List<Users>> getAllUsers() throws UserException{
			return new ResponseEntity<List<Users>>(usersService.getAllUsers(), HttpStatus.OK);
		}
		
		@GetMapping("/{userId}")
		public ResponseEntity<Users> getUserById(@PathVariable("userId") int userId) throws UserException{
			ResponseEntity<Users> response=null;
			
			Users user = usersService.getUserById(userId); 
			
			if(user!=null) {
				response =new ResponseEntity<Users>(user, HttpStatus.OK); 
			}else {
				response =new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
			}
			
			return response;
		}
		
		@DeleteMapping("/{userId}")
		public ResponseEntity<Void> deleteUserById(@PathVariable("userId") int userId) throws UserException{
			ResponseEntity<Void> response=null;
			
			boolean isDeleted = usersService.deleteUser(userId);
			
			if(isDeleted) {		
				response =new ResponseEntity<>(HttpStatus.OK); 
			}else {
				response =new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return response;
		}
		
		@PostMapping
		public ResponseEntity<Users> addUser(@RequestBody Users user) throws UserException{
			return new ResponseEntity<Users>(usersService.add(user),HttpStatus.OK);
		}
		
		

}
