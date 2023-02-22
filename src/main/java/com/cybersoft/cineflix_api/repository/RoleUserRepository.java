package com.cybersoft.cineflix_api.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cybersoft.cineflix_api.entity.RoleUser;

@Repository
public interface RoleUserRepository extends JpaRepository<RoleUser, Long>{
	
	@Query(value = "call GetAllRoleByUserName(:username)", nativeQuery = true)
	List<Map<String, ?>> getRoleNameByUserName(@Param("username") String username);
	
	
}
