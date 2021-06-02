package com.mustafa.hmrs.business.abstracts;

import java.util.List;

import com.mustafa.hmrs.core.utilities.results.DataResult;
import com.mustafa.hmrs.core.utilities.results.Result;
import com.mustafa.hmrs.entities.concretes.JobSeeker;

public interface JobSeekerService {
	DataResult<List<JobSeeker>> getall();
	Result add(JobSeeker jobSeeker);

}
