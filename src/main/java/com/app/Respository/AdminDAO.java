package com.app.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Model.Admin;

@Repository
public interface AdminDAO extends JpaRepository<Admin, Integer> {
	public Admin findByMobile(String mobile);
}
