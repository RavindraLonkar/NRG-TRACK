package com.nrg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nrg.models.CodeType;

@Repository("codeTypeRepository")
public interface CodeTypeRepository extends CrudRepository<CodeType, Integer> {

	CodeType findBycodetypeid(Integer codetypeid);

}
