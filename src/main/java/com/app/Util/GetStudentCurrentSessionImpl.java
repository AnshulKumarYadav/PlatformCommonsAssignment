package com.app.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.Exception.StudentException;
import com.app.Model.CurrentStudentSession;
import com.app.Respository.StudentSessionDAO;

@Component
public class GetStudentCurrentSessionImpl implements GetStudentCurrentSession {
	
	@Autowired
	private StudentSessionDAO studentSessionDAO;

	@Override
	public CurrentStudentSession getCurrentStudentSession(String key) {
		CurrentStudentSession studentSession = studentSessionDAO.findByStudentCode(key);
		if(studentSession!=null)
		{
			return studentSession;
		}
		else {
			throw new StudentException("The user is not authorized");
		}
	}



}
