package com.savvato.collaborativeentrepreneur.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="user_skill_map")
@IdClass(UserSpecificSkillId.class)
public class UserSpecificSkill {

	private static final long serialVersionUID = 13872281L;
	
	@Id
	private Long userId;
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Id
	private Long skillId;
	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	@Id
	private Long industryId;
	public Long getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Long industryId) {
		this.industryId = industryId;
	}

	private Long skillLevelId;
	public Long getSkillLevelId() {
		return skillLevelId;
	}

	public void setSkillLevelId(Long skillLevelId) {
		this.skillLevelId = skillLevelId;
	}

	public UserSpecificSkill(Long userId, Long skillId, Long skillLevelId, Long industryId) {
		this.userId = userId;
		this.skillId = skillId;
		this.skillLevelId = skillLevelId;
		this.industryId = industryId;
	}
	
	public UserSpecificSkill() {
		
	}
}
