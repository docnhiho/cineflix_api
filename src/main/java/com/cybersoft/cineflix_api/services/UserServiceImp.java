package com.cybersoft.cineflix_api.services;

import com.cybersoft.cineflix_api.entity.Users;

public interface UserServiceImp {
	public Users findByUsername(String username);
}
