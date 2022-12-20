package com.app.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Model.StudentAddress;

@Repository
public interface StudentAddressDAO extends JpaRepository<StudentAddress, Integer> {

}
