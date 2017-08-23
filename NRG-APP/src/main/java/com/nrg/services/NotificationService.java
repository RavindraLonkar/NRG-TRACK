package com.nrg.services;

import java.util.List;

import com.nrg.models.InsuranceNotificationDetails;

public interface NotificationService {

	List<InsuranceNotificationDetails> getInsuranceNotificationList(int userid);

	
}
