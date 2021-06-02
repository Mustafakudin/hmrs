package com.mustafa.hmrs.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mustafa.hmrs.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User getByEmail(String email);

}
