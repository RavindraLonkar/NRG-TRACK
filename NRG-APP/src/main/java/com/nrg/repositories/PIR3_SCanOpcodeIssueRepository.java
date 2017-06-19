package com.nrg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.nrg.models.PIR3_SCanOpcodeIssue;

@Transactional
public interface PIR3_SCanOpcodeIssueRepository extends CrudRepository<PIR3_SCanOpcodeIssue, Long>{
	
}
