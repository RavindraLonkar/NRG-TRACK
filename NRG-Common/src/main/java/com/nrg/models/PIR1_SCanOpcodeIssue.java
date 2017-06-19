package com.nrg.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PIR1_Scanopcodeissue")
public class PIR1_SCanOpcodeIssue {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column private long pi_ID;
	@Column private String pi_Variety;
	@Column private String pi_Corb;
	@Column private Integer pi_Opcode;
	@Column private String pi_Stage;
	@Column private Integer pi_Week;
	@Column private Integer pi_Day;
	@Column private Integer pi_Shift;
	@Column private Double pi_Inoculation;
	@Column private Double pi_Bottles;
	@Column private String pi_Date;
	@Column private String pi_Time;
	@Column private Integer pi_prweek;
	@Column private Integer pi_prday;
	@Column private Integer pi_prshift;
	@Column private Integer pi_pryear;
	@Column private String pi_Branchcode;
	@Column private Integer pi_Scnopcode;
	@Column private Integer pi_PIR_No;
	@Column private Integer plant_loc;
	@Column private String block_code;	
	
	public long getPi_ID() {
		return pi_ID;
	}
	public void setPi_ID(long pi_ID) {
		this.pi_ID = pi_ID;
	}
	public String getPi_Variety() {
		return pi_Variety;
	}
	public void setPi_Variety(String pi_Variety) {
		this.pi_Variety = pi_Variety;
	}
	public String getPi_Corb() {
		return pi_Corb;
	}
	public void setPi_Corb(String pi_Corb) {
		this.pi_Corb = pi_Corb;
	}
	public Integer getPi_Opcode() {
		return pi_Opcode;
	}
	public void setPi_Opcode(Integer pi_Opcode) {
		this.pi_Opcode = pi_Opcode;
	}
	public String getPi_Stage() {
		return pi_Stage;
	}
	public void setPi_Stage(String pi_Stage) {
		this.pi_Stage = pi_Stage;
	}
	public Integer getPi_Week() {
		return pi_Week;
	}
	public void setPi_Week(Integer pi_Week) {
		this.pi_Week = pi_Week;
	}
	public Integer getPi_Day() {
		return pi_Day;
	}
	public void setPi_Day(Integer pi_Day) {
		this.pi_Day = pi_Day;
	}
	public Integer getPi_Shift() {
		return pi_Shift;
	}
	public void setPi_Shift(Integer pi_Shift) {
		this.pi_Shift = pi_Shift;
	}
	public Double getPi_Inoculation() {
		return pi_Inoculation;
	}
	public void setPi_Inoculation(Double pi_Inoculation) {
		this.pi_Inoculation = pi_Inoculation;
	}
	public Double getPi_Bottles() {
		return pi_Bottles;
	}
	public void setPi_Bottles(Double pi_Bottles) {
		this.pi_Bottles = pi_Bottles;
	}
	public String getPi_Date() {
		return pi_Date;
	}
	public void setPi_Date(String pi_Date) {
		this.pi_Date = pi_Date;
	}
	public String getPi_Time() {
		return pi_Time;
	}
	public void setPi_Time(String pi_Time) {
		this.pi_Time = pi_Time;
	}
	public Integer getPi_prweek() {
		return pi_prweek;
	}
	public void setPi_prweek(Integer pi_prweek) {
		this.pi_prweek = pi_prweek;
	}
	public Integer getPi_prday() {
		return pi_prday;
	}
	public void setPi_prday(Integer pi_prday) {
		this.pi_prday = pi_prday;
	}
	public Integer getPi_prshift() {
		return pi_prshift;
	}
	public void setPi_prshift(Integer pi_prshift) {
		this.pi_prshift = pi_prshift;
	}
	public Integer getPi_pryear() {
		return pi_pryear;
	}
	public void setPi_pryear(Integer pi_pryear) {
		this.pi_pryear = pi_pryear;
	}
	public String getPi_Branchcode() {
		return pi_Branchcode;
	}
	public void setPi_Branchcode(String pi_Branchcode) {
		this.pi_Branchcode = pi_Branchcode;
	}
	public Integer getPi_Scnopcode() {
		return pi_Scnopcode;
	}
	public void setPi_Scnopcode(Integer pi_Scnopcode) {
		this.pi_Scnopcode = pi_Scnopcode;
	}
	public Integer getPi_PIR_No() {
		return pi_PIR_No;
	}
	public void setPi_PIR_No(Integer pi_PIR_No) {
		this.pi_PIR_No = pi_PIR_No;
	}
	public Integer getPlant_loc() {
		return plant_loc;
	}
	public void setPlant_loc(Integer plant_loc) {
		this.plant_loc = plant_loc;
	}
	public String getBlock_code() {
		return block_code;
	}
	public void setBlock_code(String block_code) {
		this.block_code = block_code;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
}
