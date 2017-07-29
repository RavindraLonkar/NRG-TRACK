package com.nrg.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MST_Vechicle")
public class Vechicle {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private User user;
	@Column
	private String vechiclename;
	@Column
	private String vechiclenumber;
	@Column
	private Integer createdby;
	@Column
	private Date createddate;
	@Column
	private Integer lastmodifiedby;
	@Column
	private Date lastmodifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User userid) {
		this.user = userid;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
