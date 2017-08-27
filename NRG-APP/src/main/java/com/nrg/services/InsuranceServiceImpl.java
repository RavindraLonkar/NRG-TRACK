package com.nrg.services;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.Insurance;
import com.nrg.models.InsuranceDetails;
import com.nrg.models.Vechicle;
import com.nrg.repositories.InsuranceRepository;
import com.nrg.repositories.VehicleRepository;
import com.nrg.utils.CommonSqlQueries;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	InsuranceRepository insuranceRepository;

	@Autowired
	VehicleRepository vehicleRepository;

	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<InsuranceDetails> getInsuranceList(Integer userid) {
		Query q = entityManager.createQuery(CommonSqlQueries.GET_INSURANCES);
		q.setParameter("userid", userid);
		List<InsuranceDetails> list = q.getResultList();
		return list;
	}

	@Override
	public Insurance addInsurance(Insurance insurance, Integer vehicleid, Integer userid) {
		Vechicle vehicle = new Vechicle();
		vehicle = vehicleRepository.findVechicleByvehicleid(vehicleid);
				
		insurance.setVehicle(vehicle);
		insurance.setIsactive(1);
		insurance.setCreateddate(new Date());
		insurance.setCreatedby(userid);
		insurance.setLastmodifiedby(userid);
		insurance.setLastmodifieddate(new Date());
		
		return insuranceRepository.save(insurance);
	}

	@Override
	public Insurance updateInsurance(Insurance insurance, Integer userid) {
		Insurance newInsurance = insuranceRepository.findInsuranceByinsuranceid(insurance.getInsuranceid());
		
		newInsurance.setInsurancename(insurance.getInsurancename());
		newInsurance.setStartdate(insurance.getStartdate());
		newInsurance.setEnddate(insurance.getEnddate());
		newInsurance.setReminder(insurance.getReminder());
		newInsurance.setLastmodifiedby(userid);
		newInsurance.setLastmodifieddate(new Date());
		
		return insuranceRepository.save(newInsurance);
	}

	@Override
	public void deleteInsurances(List<Insurance> insurances, Integer userid) {
		// TODO : for Hard Delete
		/* insuranceRepository.delete(insurance); */
		for (Insurance insurance : insurances) {
			Insurance newInsurance = insuranceRepository.findInsuranceByinsuranceid(insurance.getInsuranceid());
			newInsurance.setIsactive(0);
			newInsurance.setLastmodifiedby(userid);
			newInsurance.setLastmodifieddate(new Date());
			insuranceRepository.save(newInsurance);
		}
	}

}
