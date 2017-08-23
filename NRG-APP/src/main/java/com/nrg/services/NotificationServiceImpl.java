package com.nrg.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.InsuranceNotificationDetails;
import com.nrg.utils.CommonSqlProcedures;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InsuranceNotificationDetails> getInsuranceNotificationList(int userid) {
		
		final StoredProcedureQuery storedProcedureQuery = this.entityManager
				.createNamedStoredProcedureQuery(CommonSqlProcedures.GET_INSURACE_NOTIFICATION_LIST);
		storedProcedureQuery.setParameter("userid", userid);
		storedProcedureQuery.execute();
		return storedProcedureQuery.getResultList();
	}

	
}
