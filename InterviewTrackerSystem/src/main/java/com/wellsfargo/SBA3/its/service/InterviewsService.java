package com.wellsfargo.SBA3.its.service;

import java.util.List;

import com.wellsfargo.SBA3.its.entity.Interviews;
import com.wellsfargo.SBA3.its.exceptions.UserException;


public interface InterviewsService {
	
	Interviews add(Interviews interview) throws UserException;
		
	boolean deleteInterview(int interviewId) throws UserException;
	
	Integer getTotalCount() throws UserException;

	List<Interviews> getAllInterviews() throws UserException;
	
	List<Interviews>  getAllByInterviewName(String interviewName) throws UserException;
	
	List<Interviews> getAllByInterviewerName(String interviewerName) throws UserException;

	Interviews getInterviewById(int interviewId) throws UserException;
}
