package com.mustafa.hmrs.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mustafa.hmrs.business.abstracts.RoleService;
import com.mustafa.hmrs.core.utilities.results.Result;
import com.mustafa.hmrs.entities.concretes.Role;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

	private RoleService roleService;

	@Autowired
	public RoleController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}
	@GetMapping("/getall")
	public List<Role> getall() {
		return this.roleService.getall();
	}
	
}
