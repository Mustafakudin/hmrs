package com.mustafa.hmrs.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mustafa.hmrs.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

	Employer getById(int employerId);
}
