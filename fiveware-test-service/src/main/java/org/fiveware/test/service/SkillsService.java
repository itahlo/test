package org.fiveware.test.service;

import org.fiveware.test.model.entity.Skills;
import org.fiveware.test.model.repository.SkillsRepository;

public class SkillsService {
	public SkillsService() {}
	
	public void salvar(Skills skill) {
		SkillsRepository skills = new SkillsRepository();
		skills.salvar(skill);
	}
}
