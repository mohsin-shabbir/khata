package com.khata.onsite.interfaces;

import java.util.List;

import com.khata.onsite.common.GeneralResponse;
import com.khata.onsite.entities.RulesEntity;

public interface RulesInterface {	
	GeneralResponse<?> addOrUpdateRule(RulesEntity rules);
	GeneralResponse<List<RulesEntity>> getRulesList(); 
	
	GeneralResponse<RulesEntity> getsingleRule(long ruleIdPk);
	GeneralResponse<?> deleteRule(long ruleIdPk);
	
	
}
