package com.mustafa.hmrs.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mustafa.hmrs.business.abstracts.UserService;
import com.mustafa.hmrs.core.utilities.results.DataResult;
import com.mustafa.hmrs.core.utilities.results.SuccessDataResult;
import com.mustafa.hmrs.dataAccess.UserDao;
import com.mustafa.hmrs.entities.concretes.User;
import java.util.List;

@Service

public class UserManager implements UserService{

	
	private UserDao userDao;
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao=userDao;
	}
	@Override
	public DataResult<List<User>> getall() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Data listelendi");
	}

}
