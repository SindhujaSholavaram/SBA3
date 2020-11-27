package com.wellsfargo.SBA3.its.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.SBA3.its.dao.AttendeeRepository;
import com.wellsfargo.SBA3.its.dao.InterviewsRepository;
import com.wellsfargo.SBA3.its.dao.UsersRepository;
import com.wellsfargo.SBA3.its.entity.Attendee;
import com.wellsfargo.SBA3.its.entity.Interviews;
import com.wellsfargo.SBA3.its.entity.Users;
import com.wellsfargo.SBA3.its.exceptions.UserException;


@Service
public class AttendeeServiceImp implements AttendeeService{

	@Autowired
	private AttendeeRepository attendeeRepo;
	
	@Autowired
	private UsersRepository userRepo;
	
	@Autowired
	private InterviewsRepository interviewRepo;
	
	@Override
	public Attendee addAttendee(int userId, int interviewId) throws UserException {
		Attendee attendee = new Attendee();
		if (interviewRepo.existsById(interviewId)) {
			if (userRepo.existsById(userId)) {
				int count = attendeeRepo.getInterviewAttendedByUser(userId, interviewId);
				if (count>0) {
					throw new UserException("User might already attended the interview. "); 
				} else {
					attendee.setUserId(userId);
					attendee.setInterviewId(interviewId);
					attendeeRepo.save(attendee);
				}
			} else
				throw new UserException("User Not Found");		
		} else
			throw new UserException("Interview Not Found");
		return attendee;
	}

	@Override
	public ArrayList<Interviews> getInterviewsByUserID(int userId) throws UserException {
		List<Interviews> interviews = null;
		ArrayList<Interviews> al = new ArrayList<Interviews>();
		if (userRepo.existsById(userId)) {
			
			List<Attendee> attendee = attendeeRepo.findAllByUserId(userId);
			if (attendee.isEmpty())
				throw new UserException("No interviews found");
			else {
				System.out.println("Fine till here");
				List<Integer> interviewIds = attendeeRepo.findAllInterviewsAttendedByUser(userId);				
				for (int i = 0;i<interviewIds.size();i++) {
					interviews=(interviewRepo.findAllByInterviewId(interviewIds.get(i)));
					al.add((Interviews) interviews);
				}
			}
		} else {
			throw new UserException("User Not Found");
		}
		return al;
	}

	@Override
	public ArrayList<Users> getUsersByInterviewID(int interviewId) throws UserException {
		List<Users> users = null;
		ArrayList<Users> al = new ArrayList<Users>();
		if (interviewRepo.existsById(interviewId)) {
			
			List<Attendee> attendee = attendeeRepo.findAllByInterviewId(interviewId);
			if (attendee.isEmpty())
				throw new UserException(" No users found");
			else {
				List<Integer> userIds = attendeeRepo.findAllUsersAttendedInterview(interviewId);				
				for (int i = 0;i<userIds.size();i++) {
					users=(userRepo.findAllByUserId(userIds.get(i)));
					al.add((Users) users);
				}
			}
		} else {
			throw new UserException("Interview Not Found");
		}
		return al;
	}
}
