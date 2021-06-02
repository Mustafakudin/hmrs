package com.mustafa.hmrs.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mustafa.hmrs.core.utilities.results.DataResult;
import com.mustafa.hmrs.core.utilities.results.Result;
import com.mustafa.hmrs.entities.concretes.JobAdvertisment;

public interface JobAdvertismentService {
	
	DataResult<List<JobAdvertisment>> getByIsActivateTrue(int pageNo, int pageSize);
	
	DataResult<List<JobAdvertisment>> getByCreatedAt(int pageNo, int pageSize);
	
	DataResult<List<JobAdvertisment>> getByDeadline(int pageNo, int pageSize);
	
	DataResult<List<JobAdvertisment>> getByIsActivateTrueAndCompanyName(String companyName,int pageNo, int pageSize);
	
	Result add(JobAdvertisment jobAdvertisment);
}
