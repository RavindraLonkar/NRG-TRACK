package com.nrg.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nrg.utils.CommonSqlProcedures;

@NamedStoredProcedureQuery(name = CommonSqlProcedures.GET_INSURACE_NOTIFICATION_LIST, procedureName = CommonSqlProcedures.GET_INSURACE_NOTIFICATION_LIST, resultClasses = InsuranceNotificationDetails.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "userid") })
@Entity
@Table(name = "Temp_notification")
public class InsuranceNotificationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer notificationid;

	private String vechiclename;
	private String vechiclenumber;
	private String insurancename;
	private Integer remainingdays;
	private Integer Notificationcount;

	@Column
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date startdate;
	@Column
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date enddate;

	public String getVechiclename() {
		return vechiclename;
	}

	public void setVechiclename(String vechiclename) {
		this.vechiclename = vechiclename;
	}

	public String getVechiclenumber() {
		return vechiclenumber;
	}

	public void setVechiclenumber(String vechiclenumber) {
		this.vechiclenumber = vechiclenumber;
	}

	public String getInsurancename() {
		return insurancename;
	}

	public void setInsurancename(String insurancename) {
		this.insurancename = insurancename;
	}

	public Integer getNotificationid() {
		return notificationid;
	}

	public void setNotificationid(Integer notificationid) {
		this.notificationid = notificationid;
	}

	public Integer getRemainingdays() {
		return remainingdays;
	}

	public void setRemainingdays(Integer remainingdays) {
		this.remainingdays = remainingdays;
	}

	public Integer getNotificationcount() {
		return Notificationcount;
	}

	public void setNotificationcount(Integer notificationcount) {
		Notificationcount = notificationcount;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

}
