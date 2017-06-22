package com.nrg.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TXN_User")
public class User {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column private long UserID;             
	@Column private String UserName;            
	@Column private String Password;            
	@Column private String LastName ;     		
	@Column private String MiddleName;    		
	@Column private String FirstName;     		
	@Column private Integer SalutationID;		
	@Column private String CompanyName ;        
	@Column private Date DOB;                
	@Column private Integer Age;                 
	@Column private Integer GenderID ;           
	@Column private Integer MaritalStatusID;     
	@Column private String ContactMobile  ;     
	@Column private String ContactMobile2;      
	@Column private Integer SecurityQuestionID;  
	@Column private String SecurityAnswer;      
	@Column private Integer RoleID;              
	@Column private Integer IsActive;            
	@Column private String EmailID;             
	@Column private Integer IsEMailIDConfirmed;  
	@Column private Integer IsAccountLocked;	    
	@Column private Date AccountLockDttm;		
	@Column private Date AccountLockExpiryDttm;
	@Column private Integer CreatedBy;			
	@Column private Date CreatedDate;			
	@Column private Integer LastModifiedBy;		
	@Column private Date LastModifiedDate;	
	@Column private Integer TCSignOffFlag;		
	@Column private Integer TCSignOffContentID;
	public long getUserID() {
		return UserID;
	}
	public void setUserID(long userID) {
		UserID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public Integer getSalutationID() {
		return SalutationID;
	}
	public void setSalutationID(Integer salutationID) {
		SalutationID = salutationID;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public Integer getAge() {
		return Age;
	}
	public void setAge(Integer age) {
		Age = age;
	}
	public Integer getGenderID() {
		return GenderID;
	}
	public void setGenderID(Integer genderID) {
		GenderID = genderID;
	}
	public Integer getMaritalStatusID() {
		return MaritalStatusID;
	}
	public void setMaritalStatusID(Integer maritalStatusID) {
		MaritalStatusID = maritalStatusID;
	}
	public String getContactMobile() {
		return ContactMobile;
	}
	public void setContactMobile(String contactMobile) {
		ContactMobile = contactMobile;
	}
	public String getContactMobile2() {
		return ContactMobile2;
	}
	public void setContactMobile2(String contactMobile2) {
		ContactMobile2 = contactMobile2;
	}
	public Integer getSecurityQuestionID() {
		return SecurityQuestionID;
	}
	public void setSecurityQuestionID(Integer securityQuestionID) {
		SecurityQuestionID = securityQuestionID;
	}
	public String getSecurityAnswer() {
		return SecurityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		SecurityAnswer = securityAnswer;
	}
	public Integer getRoleID() {
		return RoleID;
	}
	public void setRoleID(Integer roleID) {
		RoleID = roleID;
	}
	public Integer getIsActive() {
		return IsActive;
	}
	public void setIsActive(Integer isActive) {
		IsActive = isActive;
	}
	public String getEmailID() {
		return EmailID;
	}
	public void setEmailID(String emailID) {
		EmailID = emailID;
	}
	public Integer getIsEMailIDConfirmed() {
		return IsEMailIDConfirmed;
	}
	public void setIsEMailIDConfirmed(Integer isEMailIDConfirmed) {
		IsEMailIDConfirmed = isEMailIDConfirmed;
	}
	public Integer getIsAccountLocked() {
		return IsAccountLocked;
	}
	public void setIsAccountLocked(Integer isAccountLocked) {
		IsAccountLocked = isAccountLocked;
	}
	public Date getAccountLockDttm() {
		return AccountLockDttm;
	}
	public void setAccountLockDttm(Date accountLockDttm) {
		AccountLockDttm = accountLockDttm;
	}
	public Date getAccountLockExpiryDttm() {
		return AccountLockExpiryDttm;
	}
	public void setAccountLockExpiryDttm(Date accountLockExpiryDttm) {
		AccountLockExpiryDttm = accountLockExpiryDttm;
	}
	public Integer getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(Integer createdBy) {
		CreatedBy = createdBy;
	}
	public Date getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}
	public Integer getLastModifiedBy() {
		return LastModifiedBy;
	}
	public void setLastModifiedBy(Integer lastModifiedBy) {
		LastModifiedBy = lastModifiedBy;
	}
	public Date getLastModifiedDate() {
		return LastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		LastModifiedDate = lastModifiedDate;
	}
	public Integer getTCSignOffFlag() {
		return TCSignOffFlag;
	}
	public void setTCSignOffFlag(Integer tCSignOffFlag) {
		TCSignOffFlag = tCSignOffFlag;
	}
	public Integer getTCSignOffContentID() {
		return TCSignOffContentID;
	}
	public void setTCSignOffContentID(Integer tCSignOffContentID) {
		TCSignOffContentID = tCSignOffContentID;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
		
}
