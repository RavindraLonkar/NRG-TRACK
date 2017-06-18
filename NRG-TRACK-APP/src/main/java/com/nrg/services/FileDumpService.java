package com.nrg.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.Contamination;
import com.nrg.models.Delivery;
import com.nrg.models.DeliveryToGreen_HouseNew1;
import com.nrg.models.Discard;
import com.nrg.models.Dispatch;
import com.nrg.models.Dispatch_Return_Master;
import com.nrg.models.PGR_IssueNew;
import com.nrg.models.PGR_Production;
import com.nrg.models.PGR_ReturnNew;
import com.nrg.models.PIR1_SCanOpcodeIssue;
import com.nrg.models.PIR2_SCanOpcodeIssue;
import com.nrg.models.PIR3_SCanOpcodeIssue;
import com.nrg.models.PIR_Issue;
import com.nrg.models.PIR_Production;
import com.nrg.models.PIR_ReturnNew;
import com.nrg.repositories.ContaminationRepository;
import com.nrg.repositories.DeliveryRepository;
import com.nrg.repositories.DeliveryToGreen_HouseNew1Repository;
import com.nrg.repositories.DiscardRepository;
import com.nrg.repositories.DispatchRepository;
import com.nrg.repositories.Dispatch_Return_MasterRepository;
import com.nrg.repositories.PGR_IssueNewRepository;
import com.nrg.repositories.PGR_ProductionRepository;
import com.nrg.repositories.PGR_ReturnNewRepository;
import com.nrg.repositories.PIR1_SCanOpcodeIssueRepository;
import com.nrg.repositories.PIR2_SCanOpcodeIssueRepository;
import com.nrg.repositories.PIR3_SCanOpcodeIssueRepository;
import com.nrg.repositories.PIR_IssueRepository;
import com.nrg.repositories.PIR_ProductionRepository;
import com.nrg.repositories.PIR_ReturnNewRepository;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CustomFileUtils;
import com.nrg.utils.Response;

@Service
public class FileDumpService {
	

	@Autowired PGR_IssueNewRepository pGR_IssueNewRepository;
	@Autowired PIR1_SCanOpcodeIssueRepository pIR1_SCanOpcodeIssueRepository;
	@Autowired PIR2_SCanOpcodeIssueRepository pIR2_SCanOpcodeIssueRepository;
	@Autowired PIR3_SCanOpcodeIssueRepository pIR3_SCanOpcodeIssueRepository;
	@Autowired ContaminationRepository contaminationRepository;
	@Autowired PGR_ProductionRepository pGR_ProductionRepository;
	@Autowired PGR_ReturnNewRepository pGR_ReturnNewRepository;
	@Autowired PIR_ProductionRepository pIR_ProductionRepository;
	@Autowired PIR_ReturnNewRepository pIR_ReturnNewRepository;
	@Autowired PIR_IssueRepository pIR_IssueRepository;
	@Autowired DiscardRepository discardRepository;
	@Autowired DispatchRepository dispatchRepository;
	@Autowired Dispatch_Return_MasterRepository dispatch_Return_MasterRepository;
	@Autowired DeliveryRepository deliveryRepository;
	@Autowired DeliveryToGreen_HouseNew1Repository deliveryToGreen_HouseNew1Repository;
	
	Response response=new Response();
	
	private Logger logger = Logger.getLogger(FileDumpService.class);

	private <T> ArrayList<T> getModels(Class<T> type) {
		ArrayList<T> arrayList = new ArrayList<T>();
		return arrayList;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public Response dumpFile(File file,String shift, String objectName) {
		String fileContent = null;
		
		

			try {
				fileContent = FileUtils.readFileToString(file);
			} catch (IOException e) {
				logger.error(e.getMessage());
			}

			List<?> dataList = null;
			
			switch (objectName) {
				case "PIR1_SCANOPCODEISSUE":
					dataList = this.getModels(PIR1_SCanOpcodeIssue.class);
					CustomFileUtils<PIR1_SCanOpcodeIssue> customPIR1_SCanOpcodeIssueUtils = new CustomFileUtils<PIR1_SCanOpcodeIssue>();
					dataList = customPIR1_SCanOpcodeIssueUtils.getMappedObjectList(fileContent, new PIR1_SCanOpcodeIssue(),
							CommonConstants.PGR_ISSUNEW_HEADER);
					
					for (PIR1_SCanOpcodeIssue pIR1_SCanOpcodeIssue : (List<PIR1_SCanOpcodeIssue>) dataList) {					
						pIR1_SCanOpcodeIssue.setPi_Time(customPIR1_SCanOpcodeIssueUtils.getPrTime());
						pIR1_SCanOpcodeIssue.setPi_prweek(customPIR1_SCanOpcodeIssueUtils.getPrWeek());
						pIR1_SCanOpcodeIssue.setPi_prday(customPIR1_SCanOpcodeIssueUtils.getPrDay());
						pIR1_SCanOpcodeIssue.setPi_pryear(customPIR1_SCanOpcodeIssueUtils.getPrYear());
						//pIR1_SCanOpcodeIssue.setPi_Year(customPGR_IssueNewUtils.getPrYear());
						pIR1_SCanOpcodeIssue.setPi_prshift(Integer.parseInt(shift));
					}
					
					List<PIR1_SCanOpcodeIssue> pIR1_SCanOpcodeIssueNewList = (List<PIR1_SCanOpcodeIssue>) pIR1_SCanOpcodeIssueRepository.save((List<PIR1_SCanOpcodeIssue>) dataList);
					response = new Response(CommonConstants.KF_SCUCESS, pIR1_SCanOpcodeIssueNewList,CommonConstants.KF_SCUCESS_MESSAGE);
				break;
				case "PIR2_SCANOPCODEISSUE":
					dataList = this.getModels(PIR2_SCanOpcodeIssue.class);
					CustomFileUtils<PIR2_SCanOpcodeIssue> customPIR2_SCanOpcodeIssueUtils = new CustomFileUtils<PIR2_SCanOpcodeIssue>();
					dataList = customPIR2_SCanOpcodeIssueUtils.getMappedObjectList(fileContent, new PIR2_SCanOpcodeIssue(),
							CommonConstants.PGR_ISSUNEW_HEADER);
					
					for (PIR2_SCanOpcodeIssue pIR2_SCanOpcodeIssue : (List<PIR2_SCanOpcodeIssue>) dataList) {					
						pIR2_SCanOpcodeIssue.setPi_Time(customPIR2_SCanOpcodeIssueUtils.getPrTime());
						pIR2_SCanOpcodeIssue.setPi_prweek(customPIR2_SCanOpcodeIssueUtils.getPrWeek());
						pIR2_SCanOpcodeIssue.setPi_prday(customPIR2_SCanOpcodeIssueUtils.getPrDay());
						pIR2_SCanOpcodeIssue.setPi_pryear(customPIR2_SCanOpcodeIssueUtils.getPrYear());
						//pIR2_SCanOpcodeIssue.setPi_Year(customPIR2_SCanOpcodeIssueUtils.getYear(pIR2_SCanOpcodeIssue.getPi_Week()));
						pIR2_SCanOpcodeIssue.setPi_prshift(Integer.parseInt(shift));
					}
					
					List<PIR2_SCanOpcodeIssue> pIR2_SCanOpcodeIssueNewList = (List<PIR2_SCanOpcodeIssue>) pIR2_SCanOpcodeIssueRepository.save((List<PIR2_SCanOpcodeIssue>) dataList);
					response = new Response(CommonConstants.KF_SCUCESS, pIR2_SCanOpcodeIssueNewList,CommonConstants.KF_SCUCESS_MESSAGE);

				break;
				case "PIR3_SCANOPCODEISSUE":
					dataList = this.getModels(PIR3_SCanOpcodeIssue.class);
					CustomFileUtils<PIR3_SCanOpcodeIssue> customPIR3_SCanOpcodeIssueUtils = new CustomFileUtils<PIR3_SCanOpcodeIssue>();
					dataList = customPIR3_SCanOpcodeIssueUtils.getMappedObjectList(fileContent, new PIR3_SCanOpcodeIssue(),
							CommonConstants.PGR_ISSUNEW_HEADER);
					
					for (PIR3_SCanOpcodeIssue pIR3_SCanOpcodeIssue : (List<PIR3_SCanOpcodeIssue>) dataList) {					
						pIR3_SCanOpcodeIssue.setPi_Time(customPIR3_SCanOpcodeIssueUtils.getPrTime());
						pIR3_SCanOpcodeIssue.setPi_prweek(customPIR3_SCanOpcodeIssueUtils.getPrWeek());
						pIR3_SCanOpcodeIssue.setPi_prday(customPIR3_SCanOpcodeIssueUtils.getPrDay());
						pIR3_SCanOpcodeIssue.setPi_pryear(customPIR3_SCanOpcodeIssueUtils.getPrYear());
						//pIR3_SCanOpcodeIssue.setPi_Year(customPIR3_SCanOpcodeIssueUtils.getYear(pIR3_SCanOpcodeIssue.getPi_Week()));
						pIR3_SCanOpcodeIssue.setPi_prshift(1);
					}
					
					List<PIR3_SCanOpcodeIssue> pIR3_SCanOpcodeIssueNewList = (List<PIR3_SCanOpcodeIssue>) pIR3_SCanOpcodeIssueRepository.save((List<PIR3_SCanOpcodeIssue>) dataList);
					response = new Response(CommonConstants.KF_SCUCESS, pIR3_SCanOpcodeIssueNewList,CommonConstants.KF_SCUCESS_MESSAGE);
				break;
				case "PIR_PRODUCTION":
					dataList = this.getModels(PIR_Production.class);
					CustomFileUtils<PIR_Production> customPIR_Production = new CustomFileUtils<PIR_Production>();
					dataList = customPIR_Production.getMappedObjectList(fileContent, new PIR_Production(),
							CommonConstants.PIR_PRODUCTION_HEADER);
					
					for (PIR_Production pIR_Production : (List<PIR_Production>) dataList) {					
						pIR_Production.setPr_Time(customPIR_Production.getPrTime());
						pIR_Production.setPr_Date(customPIR_Production.getDate());
						pIR_Production.setPr_prday(customPIR_Production.getPrDay());
						pIR_Production.setPr_prweek(customPIR_Production.getPrWeek());
						pIR_Production.setPr_pryear(customPIR_Production.getPrYear());
						pIR_Production.setPr_Year(customPIR_Production.getPrYear());
						pIR_Production.setPr_prshift(Integer.parseInt(shift));
					}
					
					List<PIR_Production> pIR_ProductionList = (List<PIR_Production>) pIR_ProductionRepository.save((List<PIR_Production>) dataList);
					response = new Response(CommonConstants.KF_SCUCESS, pIR_ProductionList,CommonConstants.KF_SCUCESS_MESSAGE);

				break;
				case "PIR_ISSUE":
					dataList = this.getModels(PIR_Issue.class);
					CustomFileUtils<PIR_Issue> customPIR_Issue = new CustomFileUtils<PIR_Issue>();
					dataList = customPIR_Issue.getMappedObjectList(fileContent, new PIR_Issue(),
							CommonConstants.PIR_ISSUE_HEADER);
					
					for (PIR_Issue pIR_Issue : (List<PIR_Issue>) dataList) {					
						pIR_Issue.setPi_Time(customPIR_Issue.getPrTime());
						pIR_Issue.setPi_Date(customPIR_Issue.getDate());
						pIR_Issue.setPi_prweek(customPIR_Issue.getPrWeek());
						pIR_Issue.setPi_prday(customPIR_Issue.getPrDay());
						pIR_Issue.setPi_pryear(customPIR_Issue.getPrYear());
						pIR_Issue.setPi_Year(customPIR_Issue.getPrYear());
						pIR_Issue.setPi_prshift(Integer.parseInt(shift));
					}
					
					List<PIR_Issue> pIR_IssueList = (List<PIR_Issue>) pIR_IssueRepository.save((List<PIR_Issue>) dataList);
					response = new Response(CommonConstants.KF_SCUCESS, pIR_IssueList,CommonConstants.KF_SCUCESS_MESSAGE);

				break;
				case "PIR_RETURN":
					dataList = this.getModels(PIR_ReturnNew.class);
					CustomFileUtils<PIR_ReturnNew> customPIR_ReturnNew = new CustomFileUtils<PIR_ReturnNew>();
					dataList = customPIR_ReturnNew.getMappedObjectList(fileContent, new PIR_ReturnNew(),
							CommonConstants.PIR_RETURN_HEADER);
					
					for (PIR_ReturnNew pIR_ReturnNew : (List<PIR_ReturnNew>) dataList) {					
						pIR_ReturnNew.setPr_Time(customPIR_ReturnNew.getPrTime());
						pIR_ReturnNew.setPr_Date(customPIR_ReturnNew.getDate());
						pIR_ReturnNew.setPr_prweek(customPIR_ReturnNew.getPrWeek());
						pIR_ReturnNew.setPr_prday(customPIR_ReturnNew.getPrDay());
						pIR_ReturnNew.setPr_pryear(customPIR_ReturnNew.getPrYear());
						pIR_ReturnNew.setPr_Year(customPIR_ReturnNew.getPrYear());
						pIR_ReturnNew.setPr_prshift(Integer.parseInt(shift));
					}
					
					List<PIR_ReturnNew> pIR_ReturnNewList = (List<PIR_ReturnNew>) pIR_ReturnNewRepository.save((List<PIR_ReturnNew>) dataList);
					response = new Response(CommonConstants.KF_SCUCESS, pIR_ReturnNewList,CommonConstants.KF_SCUCESS_MESSAGE);

				break;
				case "PGR_PRODUCTION":
					dataList = this.getModels(PGR_Production.class);
					CustomFileUtils<PGR_Production> customPGR_Production = new CustomFileUtils<PGR_Production>();
					dataList = customPGR_Production.getMappedObjectList(fileContent, new PGR_Production(),
							CommonConstants.PGR_PRODUCTION_HEADER);
					
					for (PGR_Production pGR_Production : (List<PGR_Production>) dataList) {					
						pGR_Production.setPr_Time(customPGR_Production.getPrTime());
						pGR_Production.setPr_Date(customPGR_Production.getDate());
						pGR_Production.setPr_Year(customPGR_Production.getPrYear());
						pGR_Production.setCr_prweek(customPGR_Production.getPrWeek());
						pGR_Production.setCr_prday(customPGR_Production.getPrDay());
						pGR_Production.setCr_pryear(customPGR_Production.getPrYear());
						pGR_Production.setCr_prshift(Integer.parseInt(shift));
					}
					
					List<PGR_Production> pGR_ProductionList = (List<PGR_Production>) pGR_ProductionRepository.save((List<PGR_Production>) dataList);
					response = new Response(CommonConstants.KF_SCUCESS, pGR_ProductionList,CommonConstants.KF_SCUCESS_MESSAGE);

				break;
				case "PGR_ISSUENEW":
					dataList = this.getModels(PGR_IssueNew.class);
					CustomFileUtils<PGR_IssueNew> customPGR_IssueNewUtils = new CustomFileUtils<PGR_IssueNew>();
					dataList = customPGR_IssueNewUtils.getMappedObjectList(fileContent, new PGR_IssueNew(),
							CommonConstants.PGR_ISSUNEW_HEADER);
					
					for (PGR_IssueNew pGR_IssueNew : (List<PGR_IssueNew>) dataList) {					
						pGR_IssueNew.setPi_Time(customPGR_IssueNewUtils.getPrTime());
						pGR_IssueNew.setPi_Date(customPGR_IssueNewUtils.getDate());
						pGR_IssueNew.setPi_prweek(customPGR_IssueNewUtils.getPrWeek());
						pGR_IssueNew.setPi_prday(customPGR_IssueNewUtils.getPrDay());
						pGR_IssueNew.setPi_pryear(customPGR_IssueNewUtils.getPrYear());
						pGR_IssueNew.setPi_Year(customPGR_IssueNewUtils.getPrYear());
						pGR_IssueNew.setPi_prshift(Integer.parseInt(shift));
					}
					
					List<PGR_IssueNew> pgrdata = (List<PGR_IssueNew>) pGR_IssueNewRepository.save((List<PGR_IssueNew>) dataList);
					response = new Response(CommonConstants.KF_SCUCESS, pgrdata,CommonConstants.KF_SCUCESS_MESSAGE);
				break;
				case "PGR_RETURNNEW":
					dataList = this.getModels(PGR_ReturnNew.class);
					CustomFileUtils<PGR_ReturnNew> customPGR_ReturnNew = new CustomFileUtils<PGR_ReturnNew>();
					dataList = customPGR_ReturnNew.getMappedObjectList(fileContent, new PGR_ReturnNew(),
							CommonConstants.PGR_RETURNNEW_HEADER);
					
					for (PGR_ReturnNew pGR_ReturnNew : (List<PGR_ReturnNew>) dataList) {					
						pGR_ReturnNew.setPr_Time(customPGR_ReturnNew.getPrTime());
						pGR_ReturnNew.setPr_Date(customPGR_ReturnNew.getDate());
						pGR_ReturnNew.setPr_prweek(customPGR_ReturnNew.getPrWeek());
						pGR_ReturnNew.setPr_prday(customPGR_ReturnNew.getPrDay());
						pGR_ReturnNew.setPr_pryear(customPGR_ReturnNew.getPrYear());
						pGR_ReturnNew.setPr_Year(customPGR_ReturnNew.getPrYear());
						pGR_ReturnNew.setPr_prshift(Integer.parseInt(shift));
					}
					
					List<PGR_ReturnNew> pGR_ReturnNewList = (List<PGR_ReturnNew>) pGR_ReturnNewRepository.save((List<PGR_ReturnNew>) dataList);
					response = new Response(CommonConstants.KF_SCUCESS, pGR_ReturnNewList,CommonConstants.KF_SCUCESS_MESSAGE);

				break;
				case "CONTAMINATION":
					dataList = this.getModels(Contamination.class);
					CustomFileUtils<Contamination> customContamination = new CustomFileUtils<Contamination>();
					dataList = customContamination.getMappedObjectList(fileContent, new Contamination(),
							CommonConstants.CONTAMINATION_HEADER);
					
					for (Contamination contamination : (List<Contamination>) dataList) {					
						contamination.setCn_Time(customContamination.getPrTime());
						contamination.setCn_Date(customContamination.getDate());
						contamination.setCn_prweek(customContamination.getPrWeek());
						contamination.setCn_prday(customContamination.getPrDay());
						contamination.setCn_pryear(customContamination.getPrYear());
						contamination.setCn_Year(customContamination.getPrYear());
						contamination.setCn_Shift(Integer.parseInt(shift));
					}
					
					List<Contamination> contaminationList = (List<Contamination>) contaminationRepository.save((List<Contamination>) dataList);
					response = new Response(CommonConstants.KF_SCUCESS, contaminationList,CommonConstants.KF_SCUCESS_MESSAGE);

				break;
				case "DISCARD":
					dataList = this.getModels(Discard.class);
					CustomFileUtils<Discard> customDiscard = new CustomFileUtils<Discard>();
					dataList = customDiscard.getMappedObjectList(fileContent, new Discard(),
							CommonConstants.DISCARD_HEADER);
					
					for (Discard discard : (List<Discard>) dataList) {					
						discard.setDc_Time(customDiscard.getPrTime());
						discard.setDc_Date(customDiscard.getDate());
						discard.setDc_prweek(customDiscard.getPrWeek());
						discard.setDc_prday(customDiscard.getPrDay());
						discard.setDc_Year(customDiscard.getPrYear());
						discard.setDc_pryear(customDiscard.getPrYear());
						discard.setDc_prshift(Integer.parseInt(shift));
					}
					
					List<Discard> discardList = (List<Discard>) discardRepository.save((List<Discard>) dataList);
					response = new Response(CommonConstants.KF_SCUCESS, discardList,CommonConstants.KF_SCUCESS_MESSAGE);

				break;
				case "DISPATCH":
					dataList = this.getModels(Dispatch.class);
					CustomFileUtils<Dispatch> customDispatch = new CustomFileUtils<Dispatch>();
					dataList = customDispatch.getMappedObjectList(fileContent, new Dispatch(),
							CommonConstants.DISPATCH_ISSUE_HEADER);
					
					for (Dispatch dispatch : (List<Dispatch>) dataList) {					
						dispatch.setDs_Time(customDispatch.getPrTime());
						dispatch.setDs_Date(customDispatch.getDate());
						dispatch.setDs_prweek(customDispatch.getPrWeek());
						dispatch.setDs_prday(customDispatch.getPrDay());
						dispatch.setDs_Year(customDispatch.getPrYear());
						dispatch.setDs_pryear(customDispatch.getPrYear());
						dispatch.setDs_prshift(Integer.parseInt(shift));
					}
					
					List<Dispatch> dispatchList = (List<Dispatch>) dispatchRepository.save((List<Dispatch>) dataList);
					response = new Response(CommonConstants.KF_SCUCESS, dispatchList,CommonConstants.KF_SCUCESS_MESSAGE);

				break;
				case "DISPATCH_RETURN_MASTER":
					dataList = this.getModels(Dispatch_Return_Master.class);
					CustomFileUtils<Dispatch_Return_Master> customDispatch_Return_Master = new CustomFileUtils<Dispatch_Return_Master>();
					dataList = customDispatch_Return_Master.getMappedObjectList(fileContent, new Dispatch_Return_Master(),
							CommonConstants.DISPATCH_RETURN_MASTER_HEADER);
					
					for (Dispatch_Return_Master dispatch_Return_Master : (List<Dispatch_Return_Master>) dataList) {					
						dispatch_Return_Master.setDs_Time(customDispatch_Return_Master.getPrTime());
						dispatch_Return_Master.setDs_Date(customDispatch_Return_Master.getDate());
						dispatch_Return_Master.setDs_prweek(customDispatch_Return_Master.getPrWeek());
						dispatch_Return_Master.setDs_prday(customDispatch_Return_Master.getPrDay());
						dispatch_Return_Master.setDs_Year(customDispatch_Return_Master.getPrYear());
						dispatch_Return_Master.setDs_pryear(customDispatch_Return_Master.getPrYear());
						dispatch_Return_Master.setDs_prshift(Integer.parseInt(shift));
					}
					
					List<Dispatch_Return_Master> dispatch_Return_MasterList = (List<Dispatch_Return_Master>) dispatch_Return_MasterRepository.save((List<Dispatch_Return_Master>) dataList);
					response = new Response(CommonConstants.KF_SCUCESS, dispatch_Return_MasterList,CommonConstants.KF_SCUCESS_MESSAGE);

				break;
				case "DELIVERY":
					dataList = this.getModels(Delivery.class);
					CustomFileUtils<Delivery> customDelivery = new CustomFileUtils<Delivery>();
					dataList = customDelivery.getMappedObjectList(fileContent, new Delivery(),
							CommonConstants.DELIVERY_HEADER);
					
					for (Delivery delivery : (List<Delivery>) dataList) {					
						//delivery.setPr_Time(customDelivery.getPrTime());
						delivery.setDl_prweek(customDelivery.getPrWeek());
						delivery.setDl_prday(customDelivery.getPrDay());
						delivery.setDl_pryear(customDelivery.getPrYear());
						delivery.setDl_pryear(customDelivery.getPrYear());
						delivery.setDl_shift(Integer.parseInt(shift));
					}
					
					List<Delivery> deliveryList = (List<Delivery>) deliveryRepository.save((List<Delivery>) dataList);
					response = new Response(CommonConstants.KF_SCUCESS, deliveryList,"");

				break;
				case "DELIVERYTOGREEN_HOUSENEW1":
					dataList = this.getModels(DeliveryToGreen_HouseNew1.class);
					CustomFileUtils<DeliveryToGreen_HouseNew1> customDeliveryToGreen_HouseNew1 = new CustomFileUtils<DeliveryToGreen_HouseNew1>();
					dataList = customDeliveryToGreen_HouseNew1.getMappedObjectList(fileContent, new DeliveryToGreen_HouseNew1(),
							CommonConstants.DELIVERYTOGREEN_HOUSENEW1_HEADER);
					
					for (DeliveryToGreen_HouseNew1 deliveryToGreen_HouseNew1 : (List<DeliveryToGreen_HouseNew1>) dataList) {					
						deliveryToGreen_HouseNew1.setDl_Time(customDeliveryToGreen_HouseNew1.getPrTime());
						//deliveryToGreen_HouseNew1.setDl_prWeek(customDeliveryToGreen_HouseNew1.getPrWeek());
						//deliveryToGreen_HouseNew1.setDl_prday(customDeliveryToGreen_HouseNew1.getPrDay());
						deliveryToGreen_HouseNew1.setDl_pryear(customDeliveryToGreen_HouseNew1.getPrYear());
						deliveryToGreen_HouseNew1.setDl_pryear(customDeliveryToGreen_HouseNew1.getPrYear());
						//deliveryToGreen_HouseNew1.setDl_shift(Integer.parseInt(shift));
					}
					
					List<DeliveryToGreen_HouseNew1> deliveryToGreen_HouseNew1List = (List<DeliveryToGreen_HouseNew1>) deliveryToGreen_HouseNew1Repository.save((List<DeliveryToGreen_HouseNew1>) dataList);
					response = new Response(CommonConstants.KF_SCUCESS, deliveryToGreen_HouseNew1List,"");

				break;
				default:
					logger.info("No case match!");
					response = new Response(CommonConstants.KF_FAIL, null, CommonConstants.KF_FILE_VALID_MESSAGE);
			}
		
		return response;

	}
	
}
