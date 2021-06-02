package com.mustafa.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mustafa.hmrs.business.abstracts.RoleService;
import com.mustafa.hmrs.core.utilities.results.SuccesResult;
import com.mustafa.hmrs.dataAccess.RoleDao;
import com.mustafa.hmrs.entities.concretes.Role;

@Service
public class RoleManager implements RoleService {

	private RoleDao roleDao;
	@Autowired
	public RoleManager(RoleDao roleDao) {
		super();
		this.roleDao=roleDao;
		
	}
	@Override
	public List<Role> getall() {
		return this.roleDao.findAll();
	}

}
