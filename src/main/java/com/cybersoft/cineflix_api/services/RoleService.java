package com.cybersoft.cineflix_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybersoft.cineflix_api.entity.Roles;
import com.cybersoft.cineflix_api.repository.RolesRepository;

@Service
public class RoleService implements RoleServiceImp {

	@Autowired
	RolesRepository repository;
	
	@Override
	public Roles getRoleByRoleId(int roleId) {
		// TODO Auto-generated method stub
		return repository.findById(roleId).get();
	}

}
