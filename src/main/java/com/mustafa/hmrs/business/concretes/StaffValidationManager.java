package com.mustafa.hmrs.business.concretes;

import org.springframework.stereotype.Service;

import com.mustafa.hmrs.business.abstracts.StaffValidationService;
import com.mustafa.hmrs.entities.concretes.User;

@Service

public class StaffValidationManager implements StaffValidationService{

	@Override
	public boolean staffValid(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
