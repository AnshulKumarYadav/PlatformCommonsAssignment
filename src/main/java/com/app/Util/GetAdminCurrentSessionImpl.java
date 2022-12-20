package com.app.Util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.Exception.AdminException;
import com.app.Model.Admin;
import com.app.Model.CurrentAdminSession;
import com.app.Respository.AdminDAO;
import com.app.Respository.AdminSessionDAO;

@Component
public class GetAdminCurrentSessionImpl implements GetAdminCurrentSession {
	
	@Autowired
	private AdminSessionDAO adminessionDAO;
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public Integer getCurrentAdminSessionAdminId(String key){
		Optional<CurrentAdminSession> optional = adminessionDAO.findByAdminCode(key);
		
		if(!optional.isPresent()) {
			throw new AdminException("The user is not authorised as Admin");
		}
		
		return optional.get().getAdminId();
	}
	
	@Override
	public Admin getCurrentAdmin(String key) {
		Optional<CurrentAdminSession> optional = adminessionDAO.findByAdminCode(key);
		
		if(!optional.isPresent()) {
			throw new AdminException("The user is not authorised as Admin");
		}
		
		Integer adminId = optional.get().getAdminId();
		
		return  adminDAO.getById(adminId);
	}

	@Override
	public CurrentAdminSession getCurrentAdminSession(String key) {
		Optional<CurrentAdminSession> optional = adminessionDAO.findByAdminCode(key);

		if (!optional.isPresent()) {
			throw new AdminException("The user is not authorised as Admin");
		}

		return optional.get();
	}

	

}
