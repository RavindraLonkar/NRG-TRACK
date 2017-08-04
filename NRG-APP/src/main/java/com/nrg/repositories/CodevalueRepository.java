package com.nrg.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nrg.models.CodeType;
import com.nrg.models.Codevalue;

@Repository("codevalueRepository")
public interface CodevalueRepository extends CrudRepository<Codevalue, Integer> {

	List<Codevalue> findBycodetypeid(CodeType codetypeid);

}
