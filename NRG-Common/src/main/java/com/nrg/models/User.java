package com.nrg.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TXN_User")
public class User {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long userid;
	@Column
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "lastname")
	private String lastname;
	@Column
	private String middlename;

	@Column(name = "firstname")
	private String firstname;
	@Column
	private Integer salutationid;
	@Column
	private String companyname;
	@Column
	private Date dob;
	@Column
	private Integer age;
	@Column
	private Integer genderid;
	@Column
	private Integer maritalstatusid;
	@Column
	private String contactmobile;
	@Column
	private String contactmobile2;
	@Column
	private Integer securityquestionid;
	@Column
	private String securityanswer;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "roleid")
	private Role role;

	@Column
	private Integer isactive;

	@Column(name = "emailid")
	private String emailid;

	@Column
	private Integer isemailidconfirmed;
	@Column
	private Integer iscccountlocked;
	@Column
	private Date accountlockdttm;
	@Column
	private Date accountlockexpirydttm;
	@Column
	private Integer createdby;
	@Column
	private Date createddate;
	@Column
	private Integer lastmodifiedby;
	@Column
	private Date lastmodifieddate;
	@Column
	private Integer tcsignoffflag;
	@Column
	private Integer tcsignoffcontentid;

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Integer getSalutationid() {
		return salutationid;
	}

	public void setSalutationid(Integer salutationid) {
		this.salutationid = salutationid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getGenderid() {
		return genderid;
	}

	public void setGenderid(Integer genderid) {
		this.genderid = genderid;
	}

	public Integer getMaritalstatusid() {
		return maritalstatusid;
	}

	public void setMaritalstatusid(Integer maritalstatusid) {
		this.maritalstatusid = maritalstatusid;
	}

	public String getContactmobile() {
		return contactmobile;
	}

	public void setContactmobile(String contactmobile) {
		this.contactmobile = contactmobile;
	}

	public String getContactmobile2() {
		return contactmobile2;
	}

	public void setContactmobile2(String contactmobile2) {
		this.contactmobile2 = contactmobile2;
	}

	public Integer getSecurityquestionid() {
		return securityquestionid;
	}

	public void setSecurityquestionid(Integer securityquestionid) {
		this.securityquestionid = securityquestionid;
	}

	public String getSecurityanswer() {
		return securityanswer;
	}

	public void setSecurityanswer(String securityanswer) {
		this.securityanswer = securityanswer;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getIsactive() {
		return isactive;
	}

	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public Integer getIsemailidconfirmed() {
		return isemailidconfirmed;
	}

	public void setIsemailidconfirmed(Integer isemailidconfirmed) {
		this.isemailidconfirmed = isemailidconfirmed;
	}

	public Integer getIscccountlocked() {
		return iscccountlocked;
	}

	public void setIscccountlocked(Integer iscccountlocked) {
		this.iscccountlocked = iscccountlocked;
	}

	public Date getAccountlockdttm() {
		return accountlockdttm;
	}

	public void setAccountlockdttm(Date accountlockdttm) {
		this.accountlockdttm = accountlockdttm;
	}

	public Date getAccountlockexpirydttm() {
		return accountlockexpirydttm;
	}

	public void setAccountlockexpirydttm(Date accountlockexpirydttm) {
		this.accountlockexpirydttm = accountlockexpirydttm;
	}

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Integer getLastmodifiedby() {
		return lastmodifiedby;
	}

	public void setLastmodifiedby(Integer lastmodifiedby) {
		this.lastmodifiedby = lastmodifiedby;
	}

	public Date getLastmodifieddate() {
		return lastmodifieddate;
	}

	public void setLastmodifieddate(Date lastmodifieddate) {
		this.lastmodifieddate = lastmodifieddate;
	}

	public Integer getTcsignoffflag() {
		return tcsignoffflag;
	}

	public void setTcsignoffflag(Integer tcsignoffflag) {
		this.tcsignoffflag = tcsignoffflag;
	}

	public Integer getTcsignoffcontentid() {
		return tcsignoffcontentid;
	}

	public void setTcsignoffcontentid(Integer tcsignoffcontentid) {
		this.tcsignoffcontentid = tcsignoffcontentid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
