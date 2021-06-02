package com.mustafa.hmrs.business.abstracts;

import java.util.List;

import com.mustafa.hmrs.core.utilities.results.DataResult;
import com.mustafa.hmrs.core.utilities.results.Result;
import com.mustafa.hmrs.entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<List<Employer>> getall();
	Result add(Employer employer);

}
