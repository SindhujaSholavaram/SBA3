package com.wellsfargo.SBA3.its.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.SBA3.its.entity.Attendee;
import com.wellsfargo.SBA3.its.entity.Interviews;
import com.wellsfargo.SBA3.its.entity.Users;
import com.wellsfargo.SBA3.its.exceptions.UserException;
import com.wellsfargo.SBA3.its.service.AttendeeService;


@RestController
@RequestMapping("/attendee")

public class AttendeeRestController {
	
	  @Autowired private AttendeeService attendeeService;
	  
	  @PostMapping("add/{userId}/{interviewId}")
		public ResponseEntity<Attendee> addInterview(@PathVariable("userId") Integer userId, @PathVariable("interviewId") Integer interviewId) throws UserException{
			return new ResponseEntity<Attendee>(attendeeService.addAttendee(userId,interviewId),HttpStatus.OK);
		}
	  
	  @GetMapping("InterviewsAttendedByUser/{userId}")
		public ResponseEntity<ArrayList<Interviews>> getInterviewsAttendedByUser(@PathVariable("userId") Integer userId) throws UserException{
			return new ResponseEntity<ArrayList<Interviews>>(attendeeService.getInterviewsByUserID(userId),HttpStatus.OK);
		}
	  
	  @GetMapping("AttendeesOfAnInterview/{interviewId}")
		public ResponseEntity<ArrayList<Users>> getAttendeesOfAnInterview(@PathVariable("interviewId") Integer interviewId) throws UserException{
			return new ResponseEntity<ArrayList<Users>>(attendeeService.getUsersByInterviewID(interviewId),HttpStatus.OK);
		}
}
