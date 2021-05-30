package com.sidenet.prueba.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sidenet.prueba.models.ApiResponse;

@ControllerAdvice
public class RestControllerExceptionHandler {

	public ResponseEntity<ApiResponse> resolveException(ApiException exception) {
		String message = exception.getMessage();
		HttpStatus status = exception.getStatus();

		ApiResponse apiResponse = new ApiResponse();

		apiResponse.setSuccess(Boolean.FALSE);
		apiResponse.setMessage(message);

		return new ResponseEntity<>(apiResponse, status);
	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseBody
	public ResponseEntity<ApiResponse> resolveException(NotFoundException exception) {
		ApiResponse apiResponse = exception.getApiResponse();

		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
	}
}
