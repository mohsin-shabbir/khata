package com.khata.onsite.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khata.onsite.common.GeneralResponse;
import com.khata.onsite.entities.RulesEntity;
import com.khata.onsite.in.dto.RuleRequestDTO;
import com.khata.onsite.interfaces.RulesInterface;
import com.khata.onsite.repositories.RulesRepository;

@Service
public class RulesService implements RulesInterface {

	private RulesRepository rulesRepository;

	public RulesService(RulesRepository rulesRepository) {
		this.rulesRepository = rulesRepository;
	}

	
	  @Autowired 
	  ModelMapper modelMapper; 
	  private RulesEntity convertDtoToEntity(RuleRequestDTO userCreateRequest) {
	  modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	  RulesEntity user = modelMapper.map(userCreateRequest,RulesEntity.class);
	  return user; }
	

	@Override
	public GeneralResponse<?> addOrUpdateRule(RuleRequestDTO rule) {
		GeneralResponse<?> res = new GeneralResponse<>();
		try {

			RulesEntity en = new RulesEntity();
			en = this.convertDtoToEntity(rule);
			/*
			 * en.setRuleName(rule.getRuleName()); en.setRuleAmount(rule.getRuleAmount());
			 * en.setRuleDesc(rule.getRuleDesc()); en.setStatus(rule.isStatus());
			 * en.setRuleProposedBy(rule.getRuleProposedBy());
			 */
			rulesRepository.save(en);
		} catch (Exception e) {
			res.setStatus("500");
			res.setMessage("An Error Occured white Operating Rules");
			res.setError(e.getMessage());
		}
		return res;
	}

	@Override
	public GeneralResponse<List<RulesEntity>> getRulesList() {
		GeneralResponse<List<RulesEntity>> gnRes = new GeneralResponse<List<RulesEntity>>();
		List<RulesEntity> res = null;
		try {
			res = rulesRepository.findAll();
			if (res != null)
				gnRes.setData(res);
		} catch (Exception e) {

			gnRes.setStatus("500");
			gnRes.setError(e.getMessage());
		}
		return gnRes;
	}

	@Override
	public GeneralResponse<RulesEntity> getsingleRule(long ruleIdPk) {
		GeneralResponse<RulesEntity> gnRes = new GeneralResponse<RulesEntity>();
		RulesEntity res = null;
		try {
			res = rulesRepository.findByruleIdPk(ruleIdPk);
			if (res != null)
				gnRes.setData(res);
		} catch (Exception e) {

			gnRes.setStatus("500");
			gnRes.setError(e.getMessage());
		}
		return gnRes;

	}

	@Override
	public GeneralResponse<?> deleteRule(long ruleIdPk) {
		GeneralResponse<?> gnRes = new GeneralResponse<Object>();
		try {
			rulesRepository.deleteById(ruleIdPk);

		} catch (Exception e) {
			gnRes.setStatus("500");
			gnRes.setError(e.getMessage());
		}

		return gnRes;
	}

}
