package com.nrg.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public class Email {
	private int buId;
	private int notifyTypeId;
	private int deliveryChannelID ;
	private int sourceSystemID;
	private int notifyEventID;
	private int notifyPartyID;
	private Integer notifyUserID;
	private String sessionID;
	private boolean attachmentPresent;
	private int attachmentCount;
	private int attachment1DocumentID; 
	private int attachment2DocumentID ;
	private int attachment3DocumentID;
	private String deliveryLastErrorText;
	private String statusId;
	
	private String from;
	private String to;
	private String cc;
	private String bcc;
	private String subject;
	private String text;
	private Map<String, Object> contextMap;
	private ArrayList<MultipartFile> inlineImages = new ArrayList<MultipartFile>();
	private ArrayList<MultipartFile> attatchments = new ArrayList<MultipartFile>();
	private String templateUri;
	
	public int getBuId() {
		return buId;
	}
	public void setBuId(int buId) {
		this.buId = buId;
	}
	public int getNotifyTypeId() {
		return notifyTypeId;
	}
	public void setNotifyTypeId(int notifyTypeId) {
		this.notifyTypeId = notifyTypeId;
	}
	public int getDeliveryChannelID() {
		return deliveryChannelID;
	}
	public void setDeliveryChannelID(int deliveryChannelID) {
		this.deliveryChannelID = deliveryChannelID;
	}
	public int getSourceSystemID() {
		return sourceSystemID;
	}
	public void setSourceSystemID(int sourceSystemID) {
		this.sourceSystemID = sourceSystemID;
	}
	public int getNotifyEventID() {
		return notifyEventID;
	}
	public void setNotifyEventID(int notifyEventID) {
		this.notifyEventID = notifyEventID;
	}
	public int getNotifyPartyID() {
		return notifyPartyID;
	}
	public void setNotifyPartyID(int notifyPartyID) {
		this.notifyPartyID = notifyPartyID;
	}
	public Integer getNotifyUserID() {
		return notifyUserID;
	}
	public void setNotifyUserID(Integer notifyUserID) {
		this.notifyUserID = notifyUserID;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public boolean isAttachmentPresent() {
		return attachmentPresent;
	}
	public void setAttachmentPresent(boolean attachmentPresent) {
		this.attachmentPresent = attachmentPresent;
	}
	public int getAttachmentCount() {
		return attachmentCount;
	}
	public void setAttachmentCount(int attachmentCount) {
		this.attachmentCount = attachmentCount;
	}
	public int getAttachment1DocumentID() {
		return attachment1DocumentID;
	}
	public void setAttachment1DocumentID(int attachment1DocumentID) {
		this.attachment1DocumentID = attachment1DocumentID;
	}
	public int getAttachment2DocumentID() {
		return attachment2DocumentID;
	}
	public void setAttachment2DocumentID(int attachment2DocumentID) {
		this.attachment2DocumentID = attachment2DocumentID;
	}
	public int getAttachment3DocumentID() {
		return attachment3DocumentID;
	}
	public void setAttachment3DocumentID(int attachment3DocumentID) {
		this.attachment3DocumentID = attachment3DocumentID;
	}
	public String getDeliveryLastErrorText() {
		return deliveryLastErrorText;
	}
	public void setDeliveryLastErrorText(String deliveryLastErrorText) {
		this.deliveryLastErrorText = deliveryLastErrorText;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getBcc() {
		return bcc;
	}
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Map<String, Object> getContextMap() {
		return contextMap;
	}
	public void setContextMap(Map<String, Object> contextMap) {
		this.contextMap = contextMap;
	}
	public List<MultipartFile> getInlineImages() {
		return inlineImages;
	}
	public void setInlineImages(ArrayList<MultipartFile> inlineImages) {
		this.inlineImages = inlineImages;
	}
	public ArrayList<MultipartFile> getAttatchments() {
		return attatchments;
	}
	public void setAttatchments(ArrayList<MultipartFile> attatchments) {
		this.attatchments = attatchments;
	}
	public String getTemplateUri() {
		return templateUri;
	}
	public void setTemplateUri(String templateUri) {
		this.templateUri = templateUri;
	}
		
}
