package com.sidenet.prueba.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sidenet.prueba.models.ApiResponse;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private ApiResponse apiResponse;
	
	public NotFoundException(ApiResponse apiResponse) {
		super();
		this.apiResponse = apiResponse;
	}
	
    public NotFoundException(String msg) {
        super(msg);
        apiResponse = new ApiResponse(false, msg, HttpStatus.NOT_FOUND);
    }
    
    public ApiResponse getApiResponse() {
		return apiResponse;
	}
}