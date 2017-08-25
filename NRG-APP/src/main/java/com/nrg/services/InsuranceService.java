package com.nrg.services;

import java.util.List;

import com.nrg.models.Insurance;
import com.nrg.models.InsuranceDetails;

public interface InsuranceService {

	Insurance addInsurance(Insurance insurance, Integer vehicleid, String userid);

	Insurance updateInsurance(Insurance insurance);

	void deleteInsurances(List<Insurance> insurances);

	List<InsuranceDetails> getInsuranceList(Integer userid);

}
