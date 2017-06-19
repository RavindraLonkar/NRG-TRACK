package com.nrg.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PIR_Production")
public class PIR_Production {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column private long pr_ID;
	@Column private String pr_Variety;
	@Column private String pr_Corb;
	@Column private Integer pr_Opcode;
	@Column private String pr_Stage;
	@Column private Integer pr_Week;
	@Column private Integer pr_Day;
	@Column private Integer pr_Shift;
	@Column private Integer pr_Inoculation;
	@Column private Integer pr_Bottles;
	@Column private String pr_Date;
	@Column private String pr_Time;
	@Column private Integer pr_Year;
	@Column private Integer pr_pryear;
	@Column private Integer pr_prweek;
	@Column private Integer pr_prday;
	@Column private Integer pr_prshift;
	@Column private String pr_Brachcode;
	@Column private Integer pr_Plantloc;
	@Column private String pr_Blockcode;
	@Column private String pr_PIRno;
	@Column private String pr_Rackcode;
	@Column private String pr_Shelfcode;
	public long getPr_ID() {
		return pr_ID;
	}
	public void setPr_ID(long pr_ID) {
		this.pr_ID = pr_ID;
	}
	public String getPr_Variety() {
		return pr_Variety;
	}
	public void setPr_Variety(String pr_Variety) {
		this.pr_Variety = pr_Variety;
	}
	
	public Integer getPr_Opcode() {
		return pr_Opcode;
	}
	public void setPr_Opcode(Integer pr_Opcode) {
		this.pr_Opcode = pr_Opcode;
	}
	
	public Integer getPr_Week() {
		return pr_Week;
	}
	public void setPr_Week(Integer pr_Week) {
		this.pr_Week = pr_Week;
	}
	public Integer getPr_Day() {
		return pr_Day;
	}
	public void setPr_Day(Integer pr_Day) {
		this.pr_Day = pr_Day;
	}
	public Integer getPr_Shift() {
		return pr_Shift;
	}
	public void setPr_Shift(Integer pr_Shift) {
		this.pr_Shift = pr_Shift;
	}
	public Integer getPr_Inoculation() {
		return pr_Inoculation;
	}
	public void setPr_Inoculation(Integer pr_Inoculation) {
		this.pr_Inoculation = pr_Inoculation;
	}
	public Integer getPr_Bottles() {
		return pr_Bottles;
	}
	public void setPr_Bottles(Integer pr_Bottles) {
		this.pr_Bottles = pr_Bottles;
	}
	
	public String getPr_Time() {
		return pr_Time;
	}
	public void setPr_Time(String pr_Time) {
		this.pr_Time = pr_Time;
	}
	public Integer getPr_Year() {
		return pr_Year;
	}
	public void setPr_Year(Integer pr_Year) {
		this.pr_Year = pr_Year;
	}
	
	public String getPr_Corb() {
		return pr_Corb;
	}
	public void setPr_Corb(String pr_Corb) {
		this.pr_Corb = pr_Corb;
	}
	public String getPr_Stage() {
		return pr_Stage;
	}
	public void setPr_Stage(String pr_Stage) {
		this.pr_Stage = pr_Stage;
	}
	public String getPr_Date() {
		return pr_Date;
	}
	public void setPr_Date(String pr_Date) {
		this.pr_Date = pr_Date;
	}
	public Integer getPr_pryear() {
		return pr_pryear;
	}
	public void setPr_pryear(Integer pr_pryear) {
		this.pr_pryear = pr_pryear;
	}
	public Integer getPr_prweek() {
		return pr_prweek;
	}
	public void setPr_prweek(Integer pr_prweek) {
		this.pr_prweek = pr_prweek;
	}
	public Integer getPr_prday() {
		return pr_prday;
	}
	public void setPr_prday(Integer pr_prday) {
		this.pr_prday = pr_prday;
	}
	public Integer getPr_prshift() {
		return pr_prshift;
	}
	public void setPr_prshift(Integer pr_prshift) {
		this.pr_prshift = pr_prshift;
	}
	public String getPr_Brachcode() {
		return pr_Brachcode;
	}
	public void setPr_Brachcode(String pr_Brachcode) {
		this.pr_Brachcode = pr_Brachcode;
	}
	public Integer getPr_Plantloc() {
		return pr_Plantloc;
	}
	public void setPr_Plantloc(Integer pr_Plantloc) {
		this.pr_Plantloc = pr_Plantloc;
	}
	public String getPr_Blockcode() {
		return pr_Blockcode;
	}
	public void setPr_Blockcode(String pr_Blockcode) {
		this.pr_Blockcode = pr_Blockcode;
	}
	public String getPr_PIRno() {
		return pr_PIRno;
	}
	public void setPr_PIRno(String pr_PIRno) {
		this.pr_PIRno = pr_PIRno;
	}
	public String getPr_Rackcode() {
		return pr_Rackcode;
	}
	public void setPr_Rackcode(String pr_Rackcode) {
		this.pr_Rackcode = pr_Rackcode;
	}
	public String getPr_Shelfcode() {
		return pr_Shelfcode;
	}
	public void setPr_Shelfcode(String pr_Shelfcode) {
		this.pr_Shelfcode = pr_Shelfcode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
}
