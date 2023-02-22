package com.cybersoft.cineflix_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybersoft.cineflix_api.helper.JwtProvider;
import com.cybersoft.cineflix_api.payload.LoginRequest;

@RestController
@RequestMapping("/api/v1")
public class LoginController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
		//Hàm dùng để kích hoạt đăng nhập bằng tay
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequest.getUsername(),
						loginRequest.getPassword()
						)
				);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		//Tạo token
//		String jwtToken = jwtProvider.generateToken((User)authentication.getPrincipal());
		String jwtToken = jwtProvider.generateToken(loginRequest.getUsername());
		
		return new ResponseEntity<String>(jwtToken, HttpStatus.OK);
	}
	
	@GetMapping("/test")
	public String test() {
		return "Test";
	}
	
}
