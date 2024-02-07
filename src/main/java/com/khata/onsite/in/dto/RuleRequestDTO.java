package com.khata.onsite.in.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class RuleRequestDTO {
	
	@NotBlank(message = "Invalid Name: Empty name")
    @NotNull(message = "Invalid Name: Name is NULL")
    @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
	public String ruleName;
	
	
	
	@NotNull(message="Amount is Required")
	public Long ruleAmount;
	
	@NotNull(message="Proposed By is Required")
	public String ruleProposedBy;
	
	@NotNull(message="Description is Required")
	public String ruleDesc;	
	
	public boolean ruleStatus;
	
	public int ruleIdPk;
	

}
