package com.app.Model;

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
public class StudentAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressID;
	private String area;
	private String district;
	private String state;
	private String pincode;
	private String addressType;

}
