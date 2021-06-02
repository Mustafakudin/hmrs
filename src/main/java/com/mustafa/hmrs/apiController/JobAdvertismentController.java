package com.mustafa.hmrs.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mustafa.hmrs.business.abstracts.JobAdvertismentService;
import com.mustafa.hmrs.core.utilities.results.DataResult;
import com.mustafa.hmrs.core.utilities.results.Result;
import com.mustafa.hmrs.entities.concretes.JobAdvertisment;

@RestController
@RequestMapping("/api/jobadvertisment")
public class JobAdvertismentController {
	private  JobAdvertismentService jobAdvertismentService;

	@Autowired
	public JobAdvertismentController(JobAdvertismentService jobAdvertismentService) {
		super();
		this.jobAdvertismentService = jobAdvertismentService;
	}
	@GetMapping("/getByIsActivateTrue")
	public DataResult<List<JobAdvertisment>> getByIsActivateTrue(int pageNo, int pageSize) {
		return this.jobAdvertismentService.getByIsActivateTrue(pageNo, pageSize);
	}
	@GetMapping("/getByCreatedAt")
	public DataResult<List<JobAdvertisment>> getByCreatedAt(int pageNo, int pageSize) {
		return this.jobAdvertismentService.getByCreatedAt(pageNo, pageSize);
	}
	@GetMapping("/getByDeadline")
	public DataResult<List<JobAdvertisment>> getByDeadline(int pageNo, int pageSize) {
		return this.jobAdvertismentService.getByDeadline(pageNo, pageSize);
	}
	@GetMapping("/getByIsActivateTrueAndCompanyName")
	public DataResult<List<JobAdvertisment>> getByIsActivateTrueAndCompanyName(String companyName, int pageNo,
			int pageSize) {
		return this.jobAdvertismentService.getByIsActivateTrueAndCompanyName(companyName, pageNo, pageSize);
	}
	@PostMapping("/add")
	public Result  add(JobAdvertisment jobAdvertisment) {
		return this.jobAdvertismentService.add(jobAdvertisment);
	}
	

}
