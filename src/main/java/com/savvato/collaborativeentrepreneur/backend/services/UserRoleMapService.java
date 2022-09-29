package com.savvato.collaborativeentrepreneur.backend.services;

public interface UserRoleMapService {
	
	enum ROLES { ADMIN(1), BRANDSPANKINNEWBIE(2), IDEATOR(3), ENTREPRENEUR(4), MEMBER(5);
		
		private final int id;
		ROLES(int id) { this.id = id; }
		public int getValue() { return id; }
	}
	
	public void addRoleToUser(Long userId, ROLES role);
	public void removeRoleFromUser(Long userId, ROLES role);
}
