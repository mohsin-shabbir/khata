package com.khata.onsite.common;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Data;

@Data
public class GeneralResponse<T> {

	String status = "200";
	String message = "Operation Completed Successfully";
	String error = null;
	//JSONObject  data = null;
	public JsonNode jsonData;
	public T data;
	
	public GeneralResponse() {}
	
	public GeneralResponse(String stuts,String msg,String err,JsonNode data)
	{
		this.status=stuts;
		this.message=msg;
		this.error=err;
		this.jsonData=data;
	}
}
