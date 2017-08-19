package com.nrg.services;

import java.util.List;

import com.nrg.models.Insurance;

public interface InsuranceService {

	Insurance addInsurance(Insurance insurance);

	Insurance updateInsurance(Insurance insurance);

	void deleteInsurances(List<Insurance> insurances);

	List<Insurance> getInsuranceList(Integer userid);

}
