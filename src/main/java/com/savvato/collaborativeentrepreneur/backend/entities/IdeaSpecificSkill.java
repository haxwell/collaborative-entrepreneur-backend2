package com.savvato.collaborativeentrepreneur.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="idea_skill_map")
@IdClass(IdeaSpecificSkillId.class)
public class IdeaSpecificSkill {

	private static final long serialVersionUID = 26171289L;
	
	@Id
	private Long ideaId;
	public Long getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(Long ideaId) {
		this.ideaId = ideaId;
	}

	@Id
	private Long skillId;
	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

//	@Id
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

	public IdeaSpecificSkill(Long ideaId, Long skillId, Long skillLevelId, Long industryId) {
		this.ideaId = ideaId;
		this.skillId = skillId;
		this.skillLevelId = skillLevelId;
		this.industryId = industryId;
	}
	
	public IdeaSpecificSkill() {
		
	}
	
	public String toString() {
		return "skillId: " + skillId + " / skillLevelId: " + skillLevelId + " / industryId: " + industryId;
	}
}
