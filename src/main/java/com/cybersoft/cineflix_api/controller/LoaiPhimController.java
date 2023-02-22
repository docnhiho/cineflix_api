package com.cybersoft.cineflix_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybersoft.cineflix_api.entity.LoaiPhim;
import com.cybersoft.cineflix_api.services.LoaiPhimServiceImp;

@RestController
@RequestMapping("/loaiphim")
public class LoaiPhimController {
	
	@Autowired
	LoaiPhimServiceImp loaiPhimServiceImp;
	
	@GetMapping("")
	public ResponseEntity<?> getAllLoaiPhim(){
		List<LoaiPhim> loaiPhims = loaiPhimServiceImp.getAllLoaiPhim();
		
		return new ResponseEntity<List<LoaiPhim>>(loaiPhims, HttpStatus.OK);
	}
	
}
