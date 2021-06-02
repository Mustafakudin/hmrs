package com.mustafa.hmrs.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mustafa.hmrs.entities.concretes.Role;

public interface RoleDao extends JpaRepository<Role, Integer>{

}
