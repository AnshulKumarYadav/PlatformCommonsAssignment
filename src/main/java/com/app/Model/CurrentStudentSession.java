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
public class CurrentStudentSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private Integer studentId;
	
	private String studentCode;
	
	private LocalDateTime localDateTime;

	public CurrentStudentSession(Integer studentId, String studentCode, LocalDateTime localDateTime) {
		super();
		this.studentId = studentId;
		this.studentCode = studentCode;
		this.localDateTime = localDateTime;
	}

	

}
