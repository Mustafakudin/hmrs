package com.mustafa.hmrs.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mustafa.hmrs.business.abstracts.JobSeekerService;
import com.mustafa.hmrs.core.utilities.results.DataResult;
import com.mustafa.hmrs.core.utilities.results.Result;
import com.mustafa.hmrs.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getall() {
		return this.jobSeekerService.getall();
	}
	@PostMapping("/add")
	public Result add(JobSeeker jobSeeker) {
		return this.jobSeekerService.add(jobSeeker);
	}
	
}
