package com.sidenet.prueba.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sidenet.prueba.entities.Car;
import com.sidenet.prueba.entities.Driver;
import com.sidenet.prueba.exception.BadRequestException;
import com.sidenet.prueba.exception.NotFoundException;
import com.sidenet.prueba.models.ApiResponse;
import com.sidenet.prueba.models.CarRequest;
import com.sidenet.prueba.models.CarResponse;
import com.sidenet.prueba.repositories.CarRepository;
import com.sidenet.prueba.repositories.DriverRepository;
import com.sidenet.prueba.services.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * Lista todos los carros
	 */
	@Override
	public ResponseEntity<List<CarResponse>> findCars(String filter) {		
		List<Car> cars = carRepository.findByFilter(filter);
		// List<CarResponse> carResponses = Arrays.asList(modelMapper.map(carRepository.findAll(), CarResponse[].class));
		List<CarResponse> carResponses = new ArrayList<>();
		
		for (Car car : cars) {
			CarResponse res = new CarResponse();
			modelMapper.map(car, res);
			res.setDriverName(car.getDriver().getName());
			res.setDriver_id(car.getDriver().getId());
			carResponses.add(res);
		}		
		
		return ResponseEntity.ok(carResponses);
	}

	/**
	 * Crea un carro
	 */
	@Override
	public ResponseEntity<CarResponse> create(CarRequest car) {
		Optional<Car> ocar = carRepository.findByPlaque(car.getPlaque());

		if (ocar.isPresent()) throw new BadRequestException("Carro con placa (" + car.getPlaque() + ") ya existe");
		
		Driver driver = driverRepository.findById(car.getDriver_id()).orElseThrow(() -> new NotFoundException("Conductor no encontrado"));;
		
		Car newcar = new Car();
		modelMapper.map(car, newcar);	
		newcar.setDriver(driver);
		
		Car created = carRepository.save(newcar);		
		CarResponse response = new CarResponse();
		modelMapper.map(created, response);
		response.setDriverName(driver.getName());
		
		return ResponseEntity.ok(response);
	}

	/**
	 * Consulta un carro por id
	 */
	@Override
	public ResponseEntity<CarResponse> findById(Integer id) {
		Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException("Carro no encontrado"));;
		CarResponse response = new CarResponse();
		modelMapper.map(car, response);
		response.setDriver_id(car.getDriver().getId());
		return ResponseEntity.ok(response);
	}

	/**
	 * Actualiza la información de un carro
	 */
	@Override
	public ResponseEntity<CarResponse> update(CarRequest car, Integer id) {
		Optional<Car> ocar = carRepository.findByPlaque(car.getPlaque());

		if (ocar.isPresent() && ocar.get().getId() != id) throw new BadRequestException("Carro con placa (" + car.getPlaque() + ") ya existe");
		
		Car ecar = carRepository.findById(id).orElseThrow(() -> new NotFoundException("Carro no encontrado"));
		
		Driver driver = driverRepository.findById(car.getDriver_id()).orElseThrow(() -> new NotFoundException("Conductor no encontrado"));
		
		modelMapper.map(car, ecar);	
		ecar.setDriver(driver);
		
		Car updated = carRepository.save(ecar);		
		CarResponse response = new CarResponse();
		modelMapper.map(updated, response);
		response.setDriverName(driver.getName());
		
		return ResponseEntity.ok(response);
	}

	/**
	 * Elimina un carro
	 */
	@Override
	public ResponseEntity<ApiResponse> delete(Integer id) {
		carRepository.deleteById(id);
		return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, ""));
	}

}