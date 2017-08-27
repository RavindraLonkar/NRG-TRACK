package com.nrg.services;

import java.util.List;

import com.nrg.models.Insurance;
import com.nrg.models.InsuranceDetails;

public interface InsuranceService {

	Insurance addInsurance(Insurance insurance, Integer vehicleid, Integer userid);

	Insurance updateInsurance(Insurance insurance, Integer userid);

	void deleteInsurances(List<Insurance> insurances, Integer userid);

	List<InsuranceDetails> getInsuranceList(Integer userid);

}
