package com.mustafa.hmrs.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mustafa.hmrs.business.abstracts.EmployerService;
import com.mustafa.hmrs.core.utilities.results.DataResult;
import com.mustafa.hmrs.core.utilities.results.Result;
import com.mustafa.hmrs.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

	private EmployerService employerService;
	@Autowired
	public EmployerController(EmployerService employerService) {
		this.employerService=employerService;
	}
	@GetMapping("/getall")
	public DataResult<List<Employer>> getall(){
		return this.employerService.getall();
	}
	@PostMapping("/add")
	public Result add(Employer employer) {
		return this.employerService.add(employer);
	}
}
