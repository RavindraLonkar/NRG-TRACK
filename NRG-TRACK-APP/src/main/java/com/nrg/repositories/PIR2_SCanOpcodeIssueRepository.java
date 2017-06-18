package com.nrg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.nrg.models.PIR2_SCanOpcodeIssue;

@Transactional
public interface PIR2_SCanOpcodeIssueRepository extends CrudRepository<PIR2_SCanOpcodeIssue, Long>{
	
}
