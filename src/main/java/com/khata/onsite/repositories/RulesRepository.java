package com.khata.onsite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.khata.onsite.entities.RulesEntity;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "rules", path="rules")
public interface RulesRepository extends JpaRepository<RulesEntity, Long>{	
	RulesEntity findByruleIdPk(@Param("ruleIdPk") Long ruleIdPk);

}
