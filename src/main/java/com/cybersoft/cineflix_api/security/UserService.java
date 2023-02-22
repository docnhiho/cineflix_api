package com.cybersoft.cineflix_api.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cybersoft.cineflix_api.entity.RoleUser;
import com.cybersoft.cineflix_api.entity.Users;
import com.cybersoft.cineflix_api.services.RoleServiceImp;
import com.cybersoft.cineflix_api.services.RoleUserServiceImp;
import com.cybersoft.cineflix_api.services.UserServiceImp;
import com.cybersoft.cineflix_api.services.UsersService;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserServiceImp userServiceImp;
	
	@Autowired
	RoleServiceImp roleServiceImp;
	
	@Autowired
	RoleUserServiceImp roleUserServiceImp;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		
//		SimpleGrantedAuthority roleAdmin = new SimpleGrantedAuthority("ROLE_USER");
//		roles.add(roleAdmin);
//		
		Users users = userServiceImp.findByUsername(username);
		List<Map<String, ?>> listRole = roleUserServiceImp.getRoleByUserId(username);
		
		for (Map<String, ?> map : listRole) {
			SimpleGrantedAuthority roleAdmin = new SimpleGrantedAuthority(map.get("role_name").toString());
			roles.add(roleAdmin);
		}
		
		User user = new User(
				users.getUsername(), 
				users.getPassword(), 
				roles);
		
		return user;
	}

}
