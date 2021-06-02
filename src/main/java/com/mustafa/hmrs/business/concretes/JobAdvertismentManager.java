package com.mustafa.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mustafa.hmrs.business.abstracts.JobAdvertismentService;
import com.mustafa.hmrs.core.utilities.results.DataResult;
import com.mustafa.hmrs.core.utilities.results.ErrorResult;
import com.mustafa.hmrs.core.utilities.results.Result;
import com.mustafa.hmrs.core.utilities.results.SuccesResult;
import com.mustafa.hmrs.core.utilities.results.SuccessDataResult;
import com.mustafa.hmrs.dataAccess.CityDao;
import com.mustafa.hmrs.dataAccess.EmployerDao;
import com.mustafa.hmrs.dataAccess.JobAdvertismentDao;
import com.mustafa.hmrs.dataAccess.JobPositionDao;
import com.mustafa.hmrs.entities.concretes.JobAdvertisment;
@Service

public class JobAdvertismentManager implements JobAdvertismentService{

	private JobAdvertismentDao jobAdvertismentDao;
	private EmployerDao employerDao;
	private CityDao cityDao;
	private JobPositionDao jobPositionDao;
	
	
	@Autowired
	public JobAdvertismentManager(JobAdvertismentDao jobAdvertismentDao, EmployerDao employerDao, CityDao cityDao,
			JobPositionDao jobPositionDao) {
		this.jobAdvertismentDao = jobAdvertismentDao;
		this.employerDao = employerDao;
		this.cityDao = cityDao;
		this.jobPositionDao = jobPositionDao;
	}


	@Override
	public DataResult<List<JobAdvertisment>> getByIsActivateTrue(int pageNo, int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvertisment>>(this.jobAdvertismentDao.getByIsActivateTrue(pageable),"data listelendi");
		
	}


	@Override
	public DataResult<List<JobAdvertisment>> getByCreatedAt(int pageNo, int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvertisment>>(this.jobAdvertismentDao.getByCreatedAt(pageable),"data listelendi");
	}


	@Override
	public DataResult<List<JobAdvertisment>> getByDeadline(int pageNo, int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvertisment>>(this.jobAdvertismentDao.getByDeadline(pageable),"data listelendi");
	
	}


	@Override
	public DataResult<List<JobAdvertisment>> getByIsActivateTrueAndCompanyName(String companyName, int pageNo,
			int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvertisment>>(this.jobAdvertismentDao.getByIsActivateTrueAndCompanyName(companyName, pageable),"data listelendi");
	}


	/**
	 *
	 */
	@Override
	public Result add(JobAdvertisment jobAdvertisment) {
		if(jobAdvertisment.getCity()==null||
				jobAdvertisment.getDescription()==null||
				jobAdvertisment.getEmployer()==null||
				jobAdvertisment.getJobPosition()==null||
				jobAdvertisment.getDeadline()==null||
				jobAdvertisment.getQuantityOpenPosition()<1) {
			return new ErrorResult("lütfen ilgili alanları doldurunuz");
			
		}
		else if ( employerDao.findById(jobAdvertisment.getEmployer().getId()) == null ) {
			return new ErrorResult("Kullanıcı bulunamadı");
		}
		else if(cityDao.getById(jobAdvertisment.getCity().getId())==null) {
			return new ErrorResult("Sehir bulunamadı");
		}
//		else if(jobPositionDao.getById(jobAdvertisment.getJobPosition())) {
//			return new ErrorResult("iş pozisyonu bulunamadı");
//			
//		}
		else {
			jobAdvertisment.setActivate(true);
			this.jobAdvertismentDao.save(jobAdvertisment);
			return new SuccesResult("iş ilanı eklendi");
		}
}
	


}	