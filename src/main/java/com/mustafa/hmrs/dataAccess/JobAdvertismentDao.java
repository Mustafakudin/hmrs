package com.mustafa.hmrs.dataAccess;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mustafa.hmrs.entities.concretes.JobAdvertisment;

public interface JobAdvertismentDao extends JpaRepository<JobAdvertisment, Integer>{
	
	JobAdvertisment getById(int jobAdventismentId);
	
	List<JobAdvertisment> getByIsActivateTrue(Pageable pageable);
	List<JobAdvertisment> getByCreatedAt(Pageable pageable);
	List<JobAdvertisment> getByDeadline(Pageable pageable);
	List<JobAdvertisment> getByIsActivateTrueAndCompanyName(String companyName,Pageable pagebale);
	//List<JobAdvertisment> getByIsActivateTrueAndCompanyNameContains(String companyName,Pageable pageable);
}
