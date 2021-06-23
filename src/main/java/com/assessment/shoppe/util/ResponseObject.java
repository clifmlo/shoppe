package com.assessment.shoppe.util;

import org.springframework.stereotype.Component;

@Component
public class ResponseObject {
	private String resultCode;
	private String resultMsg;
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	@Override
	public String toString() {
		return "ResponseObject [resultCode=" + resultCode + ", resultMsg=" + resultMsg + "]";
	}
}
