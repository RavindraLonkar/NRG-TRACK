package com.nrg.services;

import java.util.List;

import com.nrg.models.Codevalue;

public interface CommonService {

	List<Codevalue> getCodevalues(int codetypeId);
	
}
