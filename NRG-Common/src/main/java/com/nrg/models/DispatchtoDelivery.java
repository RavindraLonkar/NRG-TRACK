package com.nrg.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DispatchtoDelivery")
public class DispatchtoDelivery {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column private long Vm_id;
	@Column private String vm_Crop;
	@Column private String vm_Subcrop;
	@Column private String vm_VarietyID;
	@Column private String pr_Corb;
	@Column private String pr_Stage;
	@Column private Integer pr_Week;
	@Column private Double pr_Year;
	@Column private String Production;
	@Column private String Used;
	@Column private String contamination;
	@Column private String Discard;
	@Column private String Dispatch;
	@Column private String Dis;
	@Column private Integer plant_loc;
	@Column private String block_code;
	public long getVm_id() {
		return Vm_id;
	}
	public void setVm_id(long vm_id) {
		Vm_id = vm_id;
	}
	public String getVm_Crop() {
		return vm_Crop;
	}
	public void setVm_Crop(String vm_Crop) {
		this.vm_Crop = vm_Crop;
	}
	public String getVm_Subcrop() {
		return vm_Subcrop;
	}
	public void setVm_Subcrop(String vm_Subcrop) {
		this.vm_Subcrop = vm_Subcrop;
	}
	public String getVm_VarietyID() {
		return vm_VarietyID;
	}
	public void setVm_VarietyID(String vm_VarietyID) {
		this.vm_VarietyID = vm_VarietyID;
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
	public Integer getPr_Week() {
		return pr_Week;
	}
	public void setPr_Week(Integer pr_Week) {
		this.pr_Week = pr_Week;
	}
	public Double getPr_Year() {
		return pr_Year;
	}
	public void setPr_Year(Double pr_Year) {
		this.pr_Year = pr_Year;
	}
	public String getProduction() {
		return Production;
	}
	public void setProduction(String production) {
		Production = production;
	}
	public String getUsed() {
		return Used;
	}
	public void setUsed(String used) {
		Used = used;
	}
	public String getContamination() {
		return contamination;
	}
	public void setContamination(String contamination) {
		this.contamination = contamination;
	}
	public String getDiscard() {
		return Discard;
	}
	public void setDiscard(String discard) {
		Discard = discard;
	}
	public String getDispatch() {
		return Dispatch;
	}
	public void setDispatch(String dispatch) {
		Dispatch = dispatch;
	}
	public String getDis() {
		return Dis;
	}
	public void setDis(String dis) {
		Dis = dis;
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
