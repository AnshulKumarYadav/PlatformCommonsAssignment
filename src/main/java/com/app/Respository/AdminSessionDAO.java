package com.app.Respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Model.CurrentAdminSession;

@Repository
public interface AdminSessionDAO extends JpaRepository<CurrentAdminSession, Integer> {
	
	public Optional<CurrentAdminSession> findByAdminCode(String adminCode);
	
	public Optional<CurrentAdminSession> findByAdminId(Integer adminId);
	
}
