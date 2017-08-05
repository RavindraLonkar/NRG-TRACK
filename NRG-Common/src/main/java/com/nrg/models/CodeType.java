package com.nrg.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CFG_Codetype")
public class CodeType {

	@Id
	@Column
	private Integer codetypeid;
	@Column
	private String codetype;
	@Column
	private String codetypedescription;
	@Column
	private Integer createdby;
	@Column
	private String createddate;
	@Column
	private Integer lastmodifiedby;
	@Column
	private String lastmodifieddate;
	@Column
	private Integer isactive;
	public Integer getCodetypeid() {
		return codetypeid;
	}
	public void setCodetypeid(Integer codetypeid) {
		this.codetypeid = codetypeid;
	}
	public String getCodetype() {
		return codetype;
	}
	public void setCodetype(String codetype) {
		this.codetype = codetype;
	}
	public String getCodetypedescription() {
		return codetypedescription;
	}
	public void setCodetypedescription(String codetypedescription) {
		this.codetypedescription = codetypedescription;
	}
	public Integer getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	public Integer getLastmodifiedby() {
		return lastmodifiedby;
	}
	public void setLastmodifiedby(Integer lastmodifiedby) {
		this.lastmodifiedby = lastmodifiedby;
	}
	public String getLastmodifieddate() {
		return lastmodifieddate;
	}
	public void setLastmodifieddate(String lastmodifieddate) {
		this.lastmodifieddate = lastmodifieddate;
	}
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}

	

}
