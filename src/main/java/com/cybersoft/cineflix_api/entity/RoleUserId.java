package com.cybersoft.cineflix_api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/* class này chứa 2 khoá chính của bảng trung gian trong quan hệ nhiều nhiều */
@Embeddable
public class RoleUserId implements Serializable{
	
	@Column(name ="role_id")
	private long roleId;
	@Column(name = "user_id")
	private long userId;
	
	public RoleUserId(long roleid, long userid) {
		// TODO Auto-generated constructor stub
		this.roleId = roleId;
		this.userId = userId;
	}
	
	private RoleUserId() {
		
	}
}
