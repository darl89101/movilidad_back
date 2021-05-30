package com.sidenet.prueba.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sidenet.prueba.entities.Car;
import com.sidenet.prueba.entities.Displacement;
import com.sidenet.prueba.exception.NotFoundException;
import com.sidenet.prueba.models.ApiResponse;
import com.sidenet.prueba.repositories.CarRepository;
import com.sidenet.prueba.repositories.DisplacementRepository;
import com.sidenet.prueba.services.DisplacementService;

@Service
public class DisplacementServiceImpl implements DisplacementService {

	@Autowired
	private DisplacementRepository displacementRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	/**
	 * Lista todos los desplazamientos
	 */
	@Override
	public ResponseEntity<List<Displacement>> findAll(String filter) {
		return ResponseEntity.ok(displacementRepository.findByFilter(filter));
	}

	/**
	 * Crea un desplazamiento
	 */
	@Override
	public ResponseEntity<Displacement> create(Displacement displacement) {
		Validate(displacement.getPlaque());
		
		Displacement created = displacementRepository.save(displacement);
		return ResponseEntity.ok(created);
	}

	/**
	 * Consulta un desplazamiento por id
	 */
	@Override
	public ResponseEntity<Displacement> findById(Integer id) {
		Displacement displacement = displacementRepository.findById(id).orElseThrow(() -> new NotFoundException("Desplazamiento no encontrado"));
		return ResponseEntity.ok(displacement);
	}

	/**
	 * Actualiza un desplazamiento
	 */
	@Override
	public ResponseEntity<Displacement> update(Displacement displacement, Integer id) {
		Validate(displacement.getPlaque());
				
		Displacement udisplacement = displacementRepository.findById(id).orElseThrow(() -> new NotFoundException("Desplazamiento no encontrado"));
		
		udisplacement.setPlaque(displacement.getPlaque());
		udisplacement.setOrigin(displacement.getOrigin());
		udisplacement.setDestination(displacement.getDestination());
		udisplacement.setOrigin_date(displacement.getOrigin_date());
		udisplacement.setDestination_date(displacement.getDestination_date());
		
		udisplacement = displacementRepository.save(udisplacement);
		return ResponseEntity.ok(udisplacement);
	}

	/**
	 * Elimina un desplazamiento
	 */
	@Override
	public ResponseEntity<ApiResponse> delete(Integer id) {
		displacementRepository.deleteById(id);
		return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, ""));
	}
	
	/**
	 * Valida que la placa exista para algún carro
	 * @param plaque
	 */
	private void Validate(String plaque) {
		Optional<Car> ocar = carRepository.findByPlaque(plaque);

		if (!ocar.isPresent()) throw new NotFoundException("Carro con placa (" + plaque + ") no encontrado!");
	}

}