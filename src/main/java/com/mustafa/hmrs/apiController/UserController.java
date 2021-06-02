package com.mustafa.hmrs.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mustafa.hmrs.business.abstracts.UserService;
import com.mustafa.hmrs.core.utilities.results.DataResult;
import com.mustafa.hmrs.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	@GetMapping("/getall")
	public DataResult<List<User>> getall() {
		return this.userService.getall();
	}
}
