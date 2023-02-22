package com.cybersoft.cineflix_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybersoft.cineflix_api.entity.Users;
import com.cybersoft.cineflix_api.repository.UserRepository;

@Service
public class UsersService implements UserServiceImp {

	@Autowired
	UserRepository repository;
	
	@Override
	public Users findByUsername(String username) {
		// TODO Auto-generated method stub
		return repository.findByUsername(username);
	}

}
