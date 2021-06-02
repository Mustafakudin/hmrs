package com.mustafa.hmrs.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mustafa.hmrs.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	JobPosition getById(int id);
	JobPosition getByName(String jobPositionName);

}
