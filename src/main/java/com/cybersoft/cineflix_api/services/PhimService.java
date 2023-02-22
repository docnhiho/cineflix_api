package com.cybersoft.cineflix_api.services;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybersoft.cineflix_api.entity.Phim;
import com.cybersoft.cineflix_api.repository.PhimRepository;

@Service
@Transactional
public class PhimService implements PhimServiceImp {

	@Autowired
	PhimRepository phimRepository;
	
	@Override
	public List<Map<String, ?>> getAllPhim() {
		// TODO Auto-generated method stub
//		return phimRepository.findAll();
		return phimRepository.getPhimWithCategory();
	}

	@Override
	public List<Map<String, ?>> getPhimByQuocGia(Integer id) {
		// TODO Auto-generated method stub
		List<Map<String, ?>> listPhim = phimRepository.getPhimByQuocGia(id);
		
		for (Map<String, ?> map : listPhim) {
			System.out.println(map.get("ten_phim"));
		}
		
		
		return listPhim;
	}

	@Override
	public void insertPhim(Phim phim) {
		// TODO Auto-generated method stub
		phimRepository.save(phim);
	}

}
