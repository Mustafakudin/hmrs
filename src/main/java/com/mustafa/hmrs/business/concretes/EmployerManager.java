package com.mustafa.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mustafa.hmrs.business.abstracts.EmployerService;
import com.mustafa.hmrs.business.abstracts.StaffValidationService;
import com.mustafa.hmrs.core.utilities.results.DataResult;
import com.mustafa.hmrs.core.utilities.results.ErrorResult;
import com.mustafa.hmrs.core.utilities.results.Result;
import com.mustafa.hmrs.core.utilities.results.SuccesResult;
import com.mustafa.hmrs.core.utilities.results.SuccessDataResult;
import com.mustafa.hmrs.dataAccess.EmployerDao;
import com.mustafa.hmrs.dataAccess.UserDao;
import com.mustafa.hmrs.entities.concretes.Employer;

@Service

public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private UserDao userDao;
	private StaffValidationService staffValidationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,UserDao userDao,StaffValidationService staffValidationService) {
		this.employerDao=employerDao;
		this.userDao=userDao;
		this.staffValidationService=staffValidationService;
	}
	
	@Override
	public DataResult<List<Employer>> getall() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"data listelendi");
	}
// kısaca tum adımaları girmesi gerektigini
	//sıfrelerin aynı olup olmadıgını 
	//aynı emil kontrolu
	@Override
	public Result add(Employer employer) {
	
		if(employer.getCompanyName()==null||
				employer.getWebSite()==null||
				employer.getEmail()==null||
				employer.getPassword()==null||
				employer.getPasswordRepeat()==null||
				employer.getCreatedDate()==null||
				employer.getPhoneNumber()==null) {
			return new ErrorResult("tüm alanları doldurunuz");
		}
		else if(!employer.getPassword().equals(employer.getPasswordRepeat())) {
			return new ErrorResult("şifreleniz uyusmuyor");
		}
		else if(userDao.getByEmail(employer.getEmail()) != null) {
			return new ErrorResult("aynı email adresını girdiniz");
		}
		else {
			if(staffValidationService.staffValid(employer)) {
				employerDao.save(employer);
				return new SuccesResult("iş veren kullanıcılara eklendi ");
			}
			else
				return new ErrorResult("iş veren kullanıcılara eklenemedi");
		}
		
	
	
	}

}
