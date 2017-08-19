package com.nrg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.Insurance;
import com.nrg.repositories.InsuranceRepository;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	InsuranceRepository insuranceRepository;

	@Override
	public List<Insurance> getInsuranceList(Integer userid) {		
		//return insuranceRepository.findUserVehiclesInsuarance(userid);
		return null;
	}

	@Override
	public Insurance addInsurance(Insurance insurance) {
		insurance.setIsactive(1);
		return insuranceRepository.save(insurance);
	}

	@Override
	public Insurance updateInsurance(Insurance insurance) {
		Insurance newInsurance = insuranceRepository.findInsuranceByinsuranceid(insurance.getInsuranceid());
		newInsurance.setInsurancename(insurance.getInsurancename());
		return insuranceRepository.save(newInsurance);
	}

	@Override
	public void deleteInsurances(List<Insurance> insurances) {
		// TODO : for Hard Delete
		/* insuranceRepository.delete(insurance); */
		for (Insurance insurance : insurances) {
			Insurance newInsurance = insuranceRepository.findInsuranceByinsuranceid(insurance.getInsuranceid());
			newInsurance.setIsactive(0);
			insuranceRepository.save(newInsurance);
		}
	}

}
