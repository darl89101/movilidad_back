package com.sidenet.prueba.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sidenet.prueba.models.ApiResponse;
import com.sidenet.prueba.models.CarRequest;
import com.sidenet.prueba.models.CarResponse;

public interface CarService {
	ResponseEntity<List<CarResponse>> findCars(String filter);
	ResponseEntity<CarResponse> create(CarRequest car);
	ResponseEntity<CarResponse> findById(Integer id);
	ResponseEntity<CarResponse> update(CarRequest car, Integer id);
	ResponseEntity<ApiResponse> delete(Integer id);
}
