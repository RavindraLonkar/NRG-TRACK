package com.nrg.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.Insurance;
import com.nrg.models.InsuranceDetails;
import com.nrg.repositories.InsuranceRepository;
import com.nrg.utils.CommonSqlQueries;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	InsuranceRepository insuranceRepository;
	
	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<InsuranceDetails> getInsuranceList(Integer userid) {		
		Query q=entityManager.createQuery(CommonSqlQueries.GET_INSURANCES);
		q.setParameter("userid", userid);
		List<InsuranceDetails> list =q.getResultList();
		return list;
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
