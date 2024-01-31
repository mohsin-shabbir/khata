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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public JsonNode getJsonData() {
		return jsonData;
	}

	public void setJsonData(JsonNode jsonData) {
		this.jsonData = jsonData;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
