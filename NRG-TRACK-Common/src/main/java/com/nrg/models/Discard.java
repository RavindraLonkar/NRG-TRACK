package com.nrg.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Discard")
public class Discard {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column private Integer dc_ID;
	@Column private String pgr_No;
	@Column private String rack_Code;
	@Column private String shelf_Code;
	@Column private String dc_Variety;
	@Column private String dc_Corb;
	@Column private Integer dc_Opcode;
	@Column private String dc_Stage;
	@Column private Integer dc_Week;
	@Column private Integer dc_Day;
	@Column private Integer dc_Shift;
	@Column private Integer dc_Inoculation;
	@Column private Integer dc_Bottles;
	@Column private String dc_Date;
	@Column private String dc_Time;
	@Column private Integer dc_prweek;
	@Column private Integer dc_prday;
	@Column private Integer dc_pryear;
	@Column private Integer dc_Year;
	@Column private String dc_branch_code;
	@Column private Integer dc_Plantloc;
	@Column private String dc_Blockcode;
	@Column private Integer dc_prshift;
	
	public Integer getDc_ID() {
		return dc_ID;
	}
	public void setDc_ID(Integer dc_ID) {
		this.dc_ID = dc_ID;
	}
	public String getPgr_No() {
		return pgr_No;
	}
	public void setPgr_No(String pgr_No) {
		this.pgr_No = pgr_No;
	}
	public String getRack_Code() {
		return rack_Code;
	}
	public void setRack_Code(String rack_Code) {
		this.rack_Code = rack_Code;
	}
	public String getShelf_Code() {
		return shelf_Code;
	}
	public void setShelf_Code(String shelf_Code) {
		this.shelf_Code = shelf_Code;
	}
	public String getDc_Variety() {
		return dc_Variety;
	}
	public void setDc_Variety(String dc_Variety) {
		this.dc_Variety = dc_Variety;
	}
	public String getDc_Corb() {
		return dc_Corb;
	}
	public void setDc_Corb(String dc_Corb) {
		this.dc_Corb = dc_Corb;
	}
	public Integer getDc_Opcode() {
		return dc_Opcode;
	}
	public void setDc_Opcode(Integer dc_Opcode) {
		this.dc_Opcode = dc_Opcode;
	}
	public String getDc_Stage() {
		return dc_Stage;
	}
	public void setDc_Stage(String dc_Stage) {
		this.dc_Stage = dc_Stage;
	}
	public Integer getDc_Week() {
		return dc_Week;
	}
	public void setDc_Week(Integer dc_Week) {
		this.dc_Week = dc_Week;
	}
	public Integer getDc_Day() {
		return dc_Day;
	}
	public void setDc_Day(Integer dc_Day) {
		this.dc_Day = dc_Day;
	}
	public Integer getDc_Shift() {
		return dc_Shift;
	}
	public void setDc_Shift(Integer dc_Shift) {
		this.dc_Shift = dc_Shift;
	}
	public Integer getDc_Inoculation() {
		return dc_Inoculation;
	}
	public void setDc_Inoculation(Integer dc_Inoculation) {
		this.dc_Inoculation = dc_Inoculation;
	}
	public Integer getDc_Bottles() {
		return dc_Bottles;
	}
	public void setDc_Bottles(Integer dc_Bottles) {
		this.dc_Bottles = dc_Bottles;
	}
	public String getDc_Date() {
		return dc_Date;
	}
	public void setDc_Date(String dc_Date) {
		this.dc_Date = dc_Date;
	}
	public String getDc_Time() {
		return dc_Time;
	}
	public void setDc_Time(String dc_Time) {
		this.dc_Time = dc_Time;
	}
	public Integer getDc_prweek() {
		return dc_prweek;
	}
	public void setDc_prweek(Integer dc_prweek) {
		this.dc_prweek = dc_prweek;
	}
	public Integer getDc_prday() {
		return dc_prday;
	}
	public void setDc_prday(Integer dc_prday) {
		this.dc_prday = dc_prday;
	}
	public Integer getDc_pryear() {
		return dc_pryear;
	}
	public void setDc_pryear(Integer dc_pryear) {
		this.dc_pryear = dc_pryear;
	}
	public Integer getDc_Year() {
		return dc_Year;
	}
	public void setDc_Year(Integer dc_Year) {
		this.dc_Year = dc_Year;
	}
	public String getDc_branch_code() {
		return dc_branch_code;
	}
	public void setDc_branch_code(String dc_branch_code) {
		this.dc_branch_code = dc_branch_code;
	}
	public Integer getDc_Plantloc() {
		return dc_Plantloc;
	}
	public void setDc_Plantloc(Integer dc_Plantloc) {
		this.dc_Plantloc = dc_Plantloc;
	}
	public String getDc_Blockcode() {
		return dc_Blockcode;
	}
	public void setDc_Blockcode(String dc_Blockcode) {
		this.dc_Blockcode = dc_Blockcode;
	}
	public Integer getDc_prshift() {
		return dc_prshift;
	}
	public void setDc_prshift(Integer dc_prshift) {
		this.dc_prshift = dc_prshift;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
