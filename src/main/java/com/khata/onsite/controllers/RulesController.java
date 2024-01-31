package com.khata.onsite.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.khata.onsite.common.GeneralResponse;
import com.khata.onsite.entities.RulesEntity;
import com.khata.onsite.interfaces.RulesInterface;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("rules")
public class RulesController {
	
	private RulesInterface rulesInterface;
	public RulesController(RulesInterface rulesInterface)
	{
		this.rulesInterface=rulesInterface;
	}
	
	@PostMapping("/addOrUpdateRule")
	public GeneralResponse<?> addOrUpdateRule(@Valid @RequestBody RulesEntity rule)
	{
		GeneralResponse<?> res =  rulesInterface.addOrUpdateRule(rule);
		return res;
	}
	
	@GetMapping("getRulesList")
	public @ResponseBody ResponseEntity<GeneralResponse<List<RulesEntity>>> getRulesList()
	{		
		GeneralResponse<List<RulesEntity>> res  =  rulesInterface.getRulesList();
		if(res.getError() == null)
			return new ResponseEntity<GeneralResponse<List<RulesEntity>>>(res, HttpStatus.OK);
		else
			return new ResponseEntity<GeneralResponse<List<RulesEntity>>>(res, HttpStatus.INTERNAL_SERVER_ERROR);			
	
	}
	@GetMapping("getSingleRule")
	public @ResponseBody ResponseEntity<GeneralResponse<RulesEntity>> getsingleRule(@RequestParam("ruleIdPk") long ruleIdPk)
	{		
		GeneralResponse<RulesEntity> res  =  rulesInterface.getsingleRule(ruleIdPk);
		if(res.getError() == null)
			return new ResponseEntity<GeneralResponse<RulesEntity>>(res, HttpStatus.OK);
		else
			return new ResponseEntity<GeneralResponse<RulesEntity>>(res, HttpStatus.INTERNAL_SERVER_ERROR);			
	
	}
	
	@GetMapping("deleteRule")
	public @ResponseBody ResponseEntity<GeneralResponse<?>> deleteRule(@RequestParam("ruleIdPk") long ruleIdPk)
	{		
		GeneralResponse<?> res  =  rulesInterface.deleteRule(ruleIdPk);
		if(res.getError() == null)
			return new ResponseEntity<GeneralResponse<?>>(res, HttpStatus.OK);
		else
			return new ResponseEntity<GeneralResponse<?>>(res, HttpStatus.INTERNAL_SERVER_ERROR);			
	
	}

}
