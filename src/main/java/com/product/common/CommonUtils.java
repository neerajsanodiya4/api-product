package com.product.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import com.product.domain.ReturnResponse;

public class CommonUtils {

	public static List<String> getErrorMessageList(List<FieldError> list) {

		List<String> errorsList = new ArrayList<String>();
		String errorDetails = null;
		for (FieldError currentFieldError : list) {
			errorDetails = currentFieldError.getDefaultMessage();
			errorDetails = errorDetails.replaceAll("field", currentFieldError.getField());
			errorsList.add(errorDetails);
		}
		return errorsList;
	}

	public static ReturnResponse getHttpStatusResponse(String message, HttpStatus status, Object res,
			String errorCode) {
		ReturnResponse returnResponse = new ReturnResponse();
		returnResponse.setStatusMessage(message);
		returnResponse.setStatusCode(status.value() + "");
		returnResponse.setData(res);
		returnResponse.setErrorCode(errorCode);
		return returnResponse;
	}
}
