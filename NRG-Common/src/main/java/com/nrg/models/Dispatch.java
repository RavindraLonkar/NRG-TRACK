package com.nrg.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Dispatch")
public class Dispatch {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column private long ds_ID;
	@Column private String Pgr_no;
	@Column private String rack_Code;
	@Column private String shelf_Code;
	@Column private String ds_Variety;
	@Column private String ds_Corb;
	@Column private Integer ds_Opcode;
	@Column private String ds_Stage;
	@Column private Integer ds_Week;
	@Column private Integer ds_Day;
	@Column private Integer ds_Shift;
	@Column private Integer ds_Inoculation;
	@Column private Double ds_Bottles;
	@Column private String ds_Date;
	@Column private String ds_Time;
	@Column private Integer ds_prweek;
	@Column private Integer ds_prday;
	@Column private Integer ds_pryear;
	@Column private Integer ds_Year;
	@Column private String branch_code;
	@Column private String ds_tblno;
	@Column private Integer dc_Plantloc;
	@Column private String dc_Blockcode;
	@Column private Integer ds_prshift;
	public long getDs_ID() {
		return ds_ID;
	}
	public void setDs_ID(long ds_ID) {
		this.ds_ID = ds_ID;
	}
	public String getPgr_no() {
		return Pgr_no;
	}
	public void setPgr_no(String pgr_no) {
		Pgr_no = pgr_no;
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
	public String getDs_Variety() {
		return ds_Variety;
	}
	public void setDs_Variety(String ds_Variety) {
		this.ds_Variety = ds_Variety;
	}
	public String getDs_Corb() {
		return ds_Corb;
	}
	public void setDs_Corb(String ds_Corb) {
		this.ds_Corb = ds_Corb;
	}
	public void setDs_Stage(String ds_Stage) {
		this.ds_Stage = ds_Stage;
	}
	public Integer getDs_Opcode() {
		return ds_Opcode;
	}
	public void setDs_Opcode(Integer ds_Opcode) {
		this.ds_Opcode = ds_Opcode;
	}
	public String getDs_Stage() {
		return ds_Stage;
	}
	public Integer getDs_Week() {
		return ds_Week;
	}
	public void setDs_Week(Integer ds_Week) {
		this.ds_Week = ds_Week;
	}
	public Integer getDs_Day() {
		return ds_Day;
	}
	public void setDs_Day(Integer ds_Day) {
		this.ds_Day = ds_Day;
	}
	public Integer getDs_Shift() {
		return ds_Shift;
	}
	public void setDs_Shift(Integer ds_Shift) {
		this.ds_Shift = ds_Shift;
	}
	public Integer getDs_Inoculation() {
		return ds_Inoculation;
	}
	public void setDs_Inoculation(Integer ds_Inoculation) {
		this.ds_Inoculation = ds_Inoculation;
	}
	public Double getDs_Bottles() {
		return ds_Bottles;
	}
	public void setDs_Bottles(Double ds_Bottles) {
		this.ds_Bottles = ds_Bottles;
	}
	public String getDs_Date() {
		return ds_Date;
	}
	public void setDs_Date(String ds_Date) {
		this.ds_Date = ds_Date;
	}
	public String getDs_Time() {
		return ds_Time;
	}
	public void setDs_Time(String ds_Time) {
		this.ds_Time = ds_Time;
	}
	public Integer getDs_prweek() {
		return ds_prweek;
	}
	public void setDs_prweek(Integer ds_prweek) {
		this.ds_prweek = ds_prweek;
	}
	public Integer getDs_prday() {
		return ds_prday;
	}
	public void setDs_prday(Integer ds_prday) {
		this.ds_prday = ds_prday;
	}
	public Integer getDs_pryear() {
		return ds_pryear;
	}
	public void setDs_pryear(Integer ds_pryear) {
		this.ds_pryear = ds_pryear;
	}
	public Integer getDs_Year() {
		return ds_Year;
	}
	public void setDs_Year(Integer ds_Year) {
		this.ds_Year = ds_Year;
	}
	public String getBranch_code() {
		return branch_code;
	}
	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}
	public String getDs_tblno() {
		return ds_tblno;
	}
	public void setDs_tblno(String ds_tblno) {
		this.ds_tblno = ds_tblno;
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
	public Integer getDs_prshift() {
		return ds_prshift;
	}
	public void setDs_prshift(Integer ds_prshift) {
		this.ds_prshift = ds_prshift;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
