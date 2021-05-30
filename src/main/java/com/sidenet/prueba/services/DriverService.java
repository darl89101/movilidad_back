package com.sidenet.prueba.services;

import java.util.List;

import com.sidenet.prueba.entities.Driver;

public interface DriverService {
	List<Driver> findDrivers(String filter);
	Driver create(Driver driver);
}
