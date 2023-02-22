package com.cybersoft.cineflix_api.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cybersoft.cineflix_api.entity.Phim;

@Repository
public interface PhimRepository extends JpaRepository<Phim, Long> {
	
	/*JQL, Native Query */
	@Query(value = "call GetPhimByQuocGia(:id)", nativeQuery = true)
	List<Map<String, ?>> getPhimByQuocGia(@Param("id") Integer id);
	
//	@Procedure("GetPhimWithCategory")
	@Query(value = "call GetPhimWithCategory", nativeQuery = true)
	List<Map<String, ?>> getPhimWithCategory();
	
}
