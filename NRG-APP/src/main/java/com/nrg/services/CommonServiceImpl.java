package com.nrg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.Codevalue;
import com.nrg.repositories.CodevalueRepository;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	CodevalueRepository codevalueRepository;

	@Override
	public List<Codevalue> getCodevalues(int codetypeid) {
		return codevalueRepository.findBycodetypeid(codetypeid);
	}

}
