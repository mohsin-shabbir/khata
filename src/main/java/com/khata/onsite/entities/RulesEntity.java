package com.khata.onsite.entities;



import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="rules")
@Data
public class RulesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rule_id_pk")
	private long ruleIdPk;
	
	@NotNull(message="ruleName By is Required")
	@Column(name="rule_name")
	private String ruleName;
	
	@NotNull(message="Proposed By is Required")
	@Column(name="proposed_by")
	private String ruleProposedBy;
	
	@NotNull(message="Amount is Required")
	@Column(name="rule_amount")
	private Long ruleAmount;
	
	@NotNull(message="Description is Required")
	@Column(name="description" , length = 255)
	private String ruleDesc;
	
	@Column(name="status")
	private boolean ruleStatus;
	
	@Column(name="created_at" , updatable = false)
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	private Date updatedAt;

}
