package com.mustafa.hmrs.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mustafa.hmrs.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	JobSeeker getByNationalIdentity(String nationalIdentity);


}
