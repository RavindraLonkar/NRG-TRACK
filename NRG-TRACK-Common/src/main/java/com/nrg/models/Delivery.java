package com.nrg.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Delivery")
public class Delivery {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column private long dl_ID;
	@Column private Integer ClientiD;
	@Column private char Client_Name;
	@Column private String dl_Variety;
	@Column private char Code;
	@Column private Integer Op_Code;
	@Column private char dl_Stage;
	@Column private Integer dl_Week;
	@Column private Integer dl_Day;
	@Column private Integer dl_shift;
	@Column private Integer dl_Plants;
	@Column private Integer dl_Box;
	@Column private Integer dl_prweek;
	@Column private Integer dl_prday;
	@Column private Integer dl_pryear;
	@Column private Integer dl_presentyear;
	@Column private String Client;
	@Column private Integer plant_loc;
	@Column private String block_code;
	public long getDl_ID() {
		return dl_ID;
	}
	public void setDl_ID(long dl_ID) {
		this.dl_ID = dl_ID;
	}
	public Integer getClientiD() {
		return ClientiD;
	}
	public void setClientiD(Integer clientiD) {
		ClientiD = clientiD;
	}
	public char getClient_Name() {
		return Client_Name;
	}
	public void setClient_Name(char client_Name) {
		Client_Name = client_Name;
	}
	public String getDl_Variety() {
		return dl_Variety;
	}
	public void setDl_Variety(String dl_Variety) {
		this.dl_Variety = dl_Variety;
	}
	public char getCode() {
		return Code;
	}
	public void setCode(char code) {
		Code = code;
	}
	public Integer getOp_Code() {
		return Op_Code;
	}
	public void setOp_Code(Integer op_Code) {
		Op_Code = op_Code;
	}
	public char getDl_Stage() {
		return dl_Stage;
	}
	public void setDl_Stage(char dl_Stage) {
		this.dl_Stage = dl_Stage;
	}
	public Integer getDl_Week() {
		return dl_Week;
	}
	public void setDl_Week(Integer dl_Week) {
		this.dl_Week = dl_Week;
	}
	public Integer getDl_Day() {
		return dl_Day;
	}
	public void setDl_Day(Integer dl_Day) {
		this.dl_Day = dl_Day;
	}
	public Integer getDl_shift() {
		return dl_shift;
	}
	public void setDl_shift(Integer dl_shift) {
		this.dl_shift = dl_shift;
	}
	public Integer getDl_Plants() {
		return dl_Plants;
	}
	public void setDl_Plants(Integer dl_Plants) {
		this.dl_Plants = dl_Plants;
	}
	public Integer getDl_Box() {
		return dl_Box;
	}
	public void setDl_Box(Integer dl_Box) {
		this.dl_Box = dl_Box;
	}
	public Integer getDl_prweek() {
		return dl_prweek;
	}
	public void setDl_prweek(Integer dl_prweek) {
		this.dl_prweek = dl_prweek;
	}
	public Integer getDl_prday() {
		return dl_prday;
	}
	public void setDl_prday(Integer dl_prday) {
		this.dl_prday = dl_prday;
	}
	public Integer getDl_pryear() {
		return dl_pryear;
	}
	public void setDl_pryear(Integer dl_pryear) {
		this.dl_pryear = dl_pryear;
	}
	public Integer getDl_presentyear() {
		return dl_presentyear;
	}
	public void setDl_presentyear(Integer dl_presentyear) {
		this.dl_presentyear = dl_presentyear;
	}
	public String getClient() {
		return Client;
	}
	public void setClient(String client) {
		Client = client;
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
