package com.app.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Model.CurrentStudentSession;

@Repository
public interface StudentSessionDAO extends JpaRepository<CurrentStudentSession, Integer> {
	
	public CurrentStudentSession findByStudentCode(String studentCode);

}
