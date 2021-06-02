package com.mustafa.hmrs.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mustafa.hmrs.business.abstracts.JobPositionService;
import com.mustafa.hmrs.core.utilities.results.DataResult;
import com.mustafa.hmrs.core.utilities.results.Result;
import com.mustafa.hmrs.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionController {

	private JobPositionService jobPositionService;
	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		this.jobPositionService=jobPositionService;
	}
	
	@GetMapping("/getall")
	 public DataResult<List<JobPosition>> getall() {
		return this.jobPositionService.getall();
	}
	@PostMapping("/add")
	public Result add(JobPosition jobPosition) {
		return this.jobPositionService.add(jobPosition);
	}
}
