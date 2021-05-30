package com.sidenet.prueba.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidenet.prueba.entities.Driver;
import com.sidenet.prueba.exception.BadRequestException;
import com.sidenet.prueba.repositories.DriverRepository;
import com.sidenet.prueba.services.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository driverRepository;
	
	/**
	 * Lista todos los conductores
	 */
	@Override
	public List<Driver> findDrivers(String filter) {
		return driverRepository.finDrivers(filter);
	}

	/**
	 * Crea un conductor
	 */
	@Override
	public Driver create(Driver driver) {
		Optional<Driver> odriver = driverRepository.findByName(driver.getName());

		if (odriver.isPresent()) throw new BadRequestException("Conductor " + driver.getName() + " ya existe");
		
		return driverRepository.save(driver);
	}

}
