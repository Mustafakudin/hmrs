package com.mustafa.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mustafa.hmrs.business.abstracts.JobPositionService;
import com.mustafa.hmrs.core.utilities.results.DataResult;
import com.mustafa.hmrs.core.utilities.results.ErrorResult;
import com.mustafa.hmrs.core.utilities.results.Result;
import com.mustafa.hmrs.core.utilities.results.SuccesResult;
import com.mustafa.hmrs.core.utilities.results.SuccessDataResult;
import com.mustafa.hmrs.dataAccess.JobPositionDao;
import com.mustafa.hmrs.entities.concretes.JobPosition;

@Service

public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao=jobPositionDao;
	}
	@Override
	public DataResult<List<JobPosition>> getall() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"data listelendi");
		
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(jobPositionDao.getByName(jobPosition.getName())!=null) {
			return new ErrorResult("aynı isimde iş pozisyonu var ");
			
		}
		else {
			return new SuccesResult("yeni iş pozisyonu eklendi");
		}
	}

}
