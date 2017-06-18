package com.nrg.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Deliverytogreen_Housenew1")
public class DeliveryToGreen_HouseNew1 {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column private long dl_Ghno;
	@Column private String dl_Varietycode;
	@Column private String dl_Code;
	@Column private String dl_Orderno;
	@Column private String dl_Plants;
	@Column private String dl_Box;
	@Column private String dl_Date;
	@Column private String dl_Time;
	@Column private String dl_Stage;
	@Column private String dl_Week;
	@Column private Integer dl_pryear;
	@Column private Integer plant_loc;
	@Column private String block_code;
	public long getDl_Ghno() {
		return dl_Ghno;
	}
	public void setDl_Ghno(long dl_Ghno) {
		this.dl_Ghno = dl_Ghno;
	}
	public String getDl_Varietycode() {
		return dl_Varietycode;
	}
	public void setDl_Varietycode(String dl_Varietycode) {
		this.dl_Varietycode = dl_Varietycode;
	}
	public String getDl_Code() {
		return dl_Code;
	}
	public void setDl_Code(String dl_Code) {
		this.dl_Code = dl_Code;
	}
	public String getDl_Orderno() {
		return dl_Orderno;
	}
	public void setDl_Orderno(String dl_Orderno) {
		this.dl_Orderno = dl_Orderno;
	}
	public String getDl_Plants() {
		return dl_Plants;
	}
	public void setDl_Plants(String dl_Plants) {
		this.dl_Plants = dl_Plants;
	}
	public String getDl_Box() {
		return dl_Box;
	}
	public void setDl_Box(String dl_Box) {
		this.dl_Box = dl_Box;
	}
	public String getDl_Date() {
		return dl_Date;
	}
	public void setDl_Date(String dl_Date) {
		this.dl_Date = dl_Date;
	}
	public String getDl_Time() {
		return dl_Time;
	}
	public void setDl_Time(String dl_Time) {
		this.dl_Time = dl_Time;
	}
	public String getDl_Stage() {
		return dl_Stage;
	}
	public void setDl_Stage(String dl_Stage) {
		this.dl_Stage = dl_Stage;
	}
	public String getDl_Week() {
		return dl_Week;
	}
	public void setDl_Week(String dl_Week) {
		this.dl_Week = dl_Week;
	}
	public Integer getDl_pryear() {
		return dl_pryear;
	}
	public void setDl_pryear(Integer dl_pryear) {
		this.dl_pryear = dl_pryear;
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
