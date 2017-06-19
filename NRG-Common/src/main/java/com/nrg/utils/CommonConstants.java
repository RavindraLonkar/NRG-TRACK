package com.nrg.utils;

public class CommonConstants {
	
	
	public static final String PIR_PRODUCTION_HEADER = "pr_Plantloc,pr_PIRno,pr_Rackcode,pr_Shelfcode,pr_Blockcode,pr_Brachcode,pr_Variety,pr_Corb,pr_Opcode,pr_Stage,pr_Week,pr_Day,pr_Shift,pr_Inoculation,pr_Bottles";
	public static final String PIR_ISSUE_HEADER = "pi_Plantloc,pi_PIR_no,pi_Rack_Code,pi_Shelfcode,pi_Blockcode,pi_Branchcode,pi_Variety,pi_Corb,pi_Opcode,pi_Stage,pi_Week,pi_Day,pi_Shift,pi_Inoculation,pi_Bottles";
	public static final String PIR_RETURN_HEADER = "pr_Plantloc,pr_PIRno,pr_Rackcode,pr_Shelfcode,pr_Blockcode,pr_Branchcode,pr_Variety,pr_Corb,pr_Opcode,pr_Stage,pr_Week,pr_Day,pr_Shift,pr_Inoculation,pr_Bottles";
	
	public static final String PGR_PRODUCTION_HEADER = "plant_loc,pgr_No,rack_Code,shelf_Code,block_code,pr_Branchcode,cr_Variety,cr_Corb,cr_Opcode,cr_Stage,cr_Week,cr_Day,cr_Shift,cr_Inoculation,cr_Bottles";
	public static final String PGR_ISSUNEW_HEADER = "plant_loc,Pgr_no,Rack_Code,Shelf_Code,block_code,pi_Branchcode,pi_Variety,pi_CorB,pi_Opcode,pi_Stage,pi_Week,pi_Day,pi_Shift,pi_Inoculation,pi_Bottles";
	public static final String PGR_RETURNNEW_HEADER = "pr_Plantloc,pgr_No,rack_Code,shelf_Code,pr_Blockcode,pr_Branchcode,pr_Variety,pr_CorB,pr_Opcode,pr_Stage,pr_Week,pr_Day,pr_Shift,pr_Inoculation,pr_Bottles";

	public static final String CONTAMINATION_HEADER = "cn_Plantloc,Pgr_no,Rack_Code,Shelf_Code,Block_Code,cn_Branchcode,cn_Variety,cn_Corb,cn_Opcode,cn_Stage,cn_Week,cn_Day,cn_Shift,cn_Inoculation,cn_Nature";
	
	public static final String DISCARD_HEADER = "dc_Plantloc,pgr_No,rack_Code,shelf_Code,dc_Blockcode,dc_branch_code,dc_Variety,dc_Corb,dc_Opcode,dc_Stage,dc_Week,dc_Day,dc_Shift,dc_Inoculation,dc_Bottles";
	
	public static final String DISPATCH_RETURN_MASTER_HEADER = "ds_Plantloc,ds_tblno,ds_Rackcode,ds_Shelfcode,ds_Blockcode,ds_Branchcode,ds_Variety,ds_Corb,ds_Opcode,ds_Stage,ds_Week,ds_Day,ds_Shif,ds_Inoculation,ds_Bottles";
	public static final String DISPATCH_ISSUE_HEADER = "dc_Plantloc,ds_tblno,rack_Code,shelf_Code,dc_Blockcode,branch_code,ds_Variety,ds_Corb,ds_Opcode,ds_Stage,ds_Week,ds_Day,ds_Shift,ds_Inoculation,ds_Bottles";
	public static final String DELIVERY_HEADER = null;
	public static final String DELIVERYTOGREEN_HOUSENEW1_HEADER = null;
	
	public static final String TEXTDATA_HEADER = null;
	
	public static final String KF_SCUCESS="1";
	public static final String KF_FAIL="0";
	public static final String KF_FILE_EMPTY="2";
	public static final String KF_FILE_EXISTS="3";
	

	public static final String KF_SCUCESS_MESSAGE="File Uploaded Successfully.";
	public static final String KF_FAIL_MESSAGE="Data Mismatch. Please Contact to Admin";
	public static final String KF_FILE_EMPTY_MESSAGE="File Is Empty";
	public static final String KF_FILE_EXISTS_MESSAGE="File Is Aready Uploaded";
	public static final String KF_FILE_VALID_MESSAGE="Please Upload Correct File";
		
}
