package com.nrg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.nrg.models.PIR1_SCanOpcodeIssue;

@Transactional
public interface PIR1_SCanOpcodeIssueRepository extends CrudRepository<PIR1_SCanOpcodeIssue, Long>{
	
}
