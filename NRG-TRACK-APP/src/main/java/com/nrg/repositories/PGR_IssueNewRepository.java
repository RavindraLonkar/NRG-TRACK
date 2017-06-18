package com.nrg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.nrg.models.PGR_IssueNew;

@Transactional
public interface PGR_IssueNewRepository extends CrudRepository<PGR_IssueNew, Long>{
	
}
