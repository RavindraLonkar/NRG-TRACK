package com.nrg.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MST_Vechicle")
public class Vechicle {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer Id;
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private User user;
	@Column private String vechicleName;
	@Column
	private Integer CreatedBy;
	@Column
	private Date CreatedDate;
	@Column
	private Integer LastModifiedBy;
	@Column
	private Date LastModifiedDate;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getVechicleName() {
		return vechicleName;
	}
	public void setVechicleName(String vechicleName) {
		this.vechicleName = vechicleName;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
