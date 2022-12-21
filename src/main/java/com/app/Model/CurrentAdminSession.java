package com.app.Model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CurrentAdminSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private Integer adminId;
	
	private String adminCode;
	
	private LocalDateTime localDateTime;
	
	
	
	public CurrentAdminSession(Integer adminId, String adminCode, LocalDateTime localDateTime) {
		super();
		this.adminId = adminId;
		this.adminCode = adminCode;
		this.localDateTime = localDateTime;
	}
	
}
