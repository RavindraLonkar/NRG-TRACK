package com.nrg.utils;

public class Response {
    private String status;
    private String resonCode;
    private Object data;
     
    public Response(){
         
    }
     
    public Response(String status, Object data,String resonCode){
        this.status = status;
        this.data = data;
        this.resonCode=resonCode;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
    public Object getData() {
        return data;
    }
 
    public void setData(Object data) {
        this.data = data;
    }

	public String getResonCode() {
		return resonCode;
	}

	public void setResonCode(String resonCode) {
		this.resonCode = resonCode;
	}

}
