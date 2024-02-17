package com.khata.onsite.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="rules")
@Data
@Getter
@Setter
public class RulesEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rule_id_pk")
	public long ruleIdPk;
	
	
	@Column(name="rule_name")
	public String ruleName;
	
	
	@Column(name="proposed_by")
	private String ruleProposedBy;
	
	
	@Column(name="rule_amount")
	public Long ruleAmount;
	
	
	@Column(name="description" , length = 255)
	public String ruleDesc;	
	
	
}
