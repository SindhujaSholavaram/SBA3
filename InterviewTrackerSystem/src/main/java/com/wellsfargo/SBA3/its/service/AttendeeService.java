package com.wellsfargo.SBA3.its.service;

import java.util.ArrayList;

import com.wellsfargo.SBA3.its.entity.Attendee;
import com.wellsfargo.SBA3.its.entity.Interviews;
import com.wellsfargo.SBA3.its.entity.Users;
import com.wellsfargo.SBA3.its.exceptions.UserException;


public interface AttendeeService {
	
	Attendee addAttendee(int userId, int interviewID) throws UserException;
	
	ArrayList<Users> getUsersByInterviewID(int interviewId) throws UserException;
	
	ArrayList<Interviews> getInterviewsByUserID(int userId) throws UserException;
}
