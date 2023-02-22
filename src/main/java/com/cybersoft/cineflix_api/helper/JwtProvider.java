package com.cybersoft.cineflix_api.helper;

import java.util.Date;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {
	//Khai báo hàm tạo token
	//Giải mã token
	//Kiểm tra token có phải do hệ thống sinh ra hay không
	
	private String SECRECT_KEY = "YWRtaW4xMjM0NTY3ODkwQGFkbWluMTIzNDU2Nzg5MEBhZG1pbjEyMzQ1Njc4OTA=";
	private long JWT_EXPIRED = 8 * 60 * 60 * 1000;
	private Gson gson = new Gson();
	
	public String generateToken(String data) {
		Date now = new Date();
		Date expriedDate = new Date(now.getTime() + JWT_EXPIRED);
		
//		String json = gson.toJson(user);
		
		return Jwts.builder()
				.setSubject(data) //Dữ liệu muốn lưu kèm ở token
				.setIssuedAt(now) //Ngày tạo token
				.setExpiration(expriedDate) //Thời gian hết hạn của token
				.signWith(SignatureAlgorithm.HS256, SECRECT_KEY) //Thuật mã hoá và mã hoá dựa trên SECRECT_KEY
				.compact();
	}
	
	public String decodeToken(String token) {
		return Jwts.parser()
				.setSigningKey(SECRECT_KEY)//Key mã hoá token ban đầu
				.parseClaimsJws(token) //truyền tham số token cần mã hoá
				.getBody().getSubject(); //Lấy giá trị
	}
	
	public boolean validationToken(String token) {
		try {
			Jwts.parser()
			.setSigningKey(SECRECT_KEY)//Key mã hoá token ban đầu
			.parseClaimsJws(token);
			
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
}
