package com.mustafa.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mustafa.hmrs.business.abstracts.JobSeekerService;
import com.mustafa.hmrs.core.utilities.results.DataResult;
import com.mustafa.hmrs.core.utilities.results.ErrorResult;
import com.mustafa.hmrs.core.utilities.results.Result;
import com.mustafa.hmrs.core.utilities.results.SuccesResult;
import com.mustafa.hmrs.core.utilities.results.SuccessDataResult;
import com.mustafa.hmrs.dataAccess.JobSeekerDao;
import com.mustafa.hmrs.dataAccess.UserDao;
import com.mustafa.hmrs.entities.concretes.JobSeeker;

@Service


public class JobSeekerManager implements JobSeekerService{
	
	private JobSeekerDao jobSeekerDao;
	private UserDao userDao;
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,UserDao userDao) {
		super();
		this.jobSeekerDao=jobSeekerDao;
		this.userDao=userDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getall() {
	return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"data listelendi");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		if(	jobSeeker.getFirstName()==null||
				jobSeeker.getEmail()==null||
				jobSeeker.getLastName()==null||
				jobSeeker.getPassword()==null||
				jobSeeker.getPasswordRepeat()==null||
				jobSeeker.getDateOfBirth()==null||
				jobSeeker.getNationalIdentity()==null||
				jobSeeker.getCreatedDate()==null) {
		return new ErrorResult("Lütfen boş birakmayınız ");
		}
		
		else if(!jobSeeker.getPassword().equals(jobSeeker.getPasswordRepeat())) {
			return new ErrorResult("şifre uyuşmazlıgı");
		}
		else if(userDao.getByEmail(jobSeeker.getEmail()) != null) {
			return new ErrorResult("email adresi kullanılmaktadır");
		}
		else if(jobSeekerDao.getByNationalIdentity(jobSeeker.getNationalIdentity()) != null) {
			return new ErrorResult("aynı tc bulunuyor");
		}
		else {
			jobSeekerDao.save(jobSeeker);
			return new SuccesResult("iş arayan kullanıcı eklendi ");
		}
	}
	

}
