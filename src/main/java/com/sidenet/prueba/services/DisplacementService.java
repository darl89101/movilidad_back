package com.sidenet.prueba.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sidenet.prueba.entities.Displacement;
import com.sidenet.prueba.models.ApiResponse;

public interface DisplacementService {
	ResponseEntity<List<Displacement>> findAll(String filter);
	ResponseEntity<Displacement> create(Displacement displacement);
	ResponseEntity<Displacement> findById(Integer id);
	ResponseEntity<Displacement> update(Displacement displacement, Integer id);
	ResponseEntity<ApiResponse> delete(Integer id);
}

