package com.khata.onsite.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {
	
	@Column(name="status")
	public boolean status;
	
	@Column(name="created_at" , updatable = false)
	@CreationTimestamp
	public Date createdAt;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	public Date updatedAt;
	
}
