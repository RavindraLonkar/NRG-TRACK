package com.nrg.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CFG_Codevalue")
public class Codevalue {

	@Id
	@Column
	private Integer codevalueid;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "codetypeid")
	private CodeType codetypeid;

	@Column
	private String codevalue;

	@Column
	private String codevaluedescription;

	@Column
	private Integer displayseqno;

	@Column
	private Integer parentcodevalueid;

	@Column
	private String mapped_value1;
	@Column
	private String mapped_value2;

	@Column
	private String mapped_value3;
	@Column
	private Integer isdefault;
	@Column
	private Integer isdisplay;
	@Column
	private Integer isactive;
	@Column
	private Integer createdby;
	@Column
	private String createddate;
	@Column
	private Integer lastmodifiedby;
	@Column
	private String lastmodifieddate;
	public Integer getCodevalueid() {
		return codevalueid;
	}
	public void setCodevalueid(Integer codevalueid) {
		this.codevalueid = codevalueid;
	}
	public CodeType getCodetypeid() {
		return codetypeid;
	}
	public void setCodetypeid(CodeType codetypeid) {
		this.codetypeid = codetypeid;
	}
	public String getCodevalue() {
		return codevalue;
	}
	public void setCodevalue(String codevalue) {
		this.codevalue = codevalue;
	}
	public String getCodevaluedescription() {
		return codevaluedescription;
	}
	public void setCodevaluedescription(String codevaluedescription) {
		this.codevaluedescription = codevaluedescription;
	}
	public Integer getDisplayseqno() {
		return displayseqno;
	}
	public void setDisplayseqno(Integer displayseqno) {
		this.displayseqno = displayseqno;
	}
	public Integer getParentcodevalueid() {
		return parentcodevalueid;
	}
	public void setParentcodevalueid(Integer parentcodevalueid) {
		this.parentcodevalueid = parentcodevalueid;
	}
	public String getMapped_value1() {
		return mapped_value1;
	}
	public void setMapped_value1(String mapped_value1) {
		this.mapped_value1 = mapped_value1;
	}
	public String getMapped_value2() {
		return mapped_value2;
	}
	public void setMapped_value2(String mapped_value2) {
		this.mapped_value2 = mapped_value2;
	}
	public String getMapped_value3() {
		return mapped_value3;
	}
	public void setMapped_value3(String mapped_value3) {
		this.mapped_value3 = mapped_value3;
	}
	public Integer getIsdefault() {
		return isdefault;
	}
	public void setIsdefault(Integer isdefault) {
		this.isdefault = isdefault;
	}
	public Integer getIsdisplay() {
		return isdisplay;
	}
	public void setIsdisplay(Integer isdisplay) {
		this.isdisplay = isdisplay;
	}
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
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

	

}
