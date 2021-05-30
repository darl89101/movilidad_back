package com.sidenet.prueba.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sidenet.prueba.entities.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
	@Query("FROM Driver WHERE name LIKE CONCAT('%',:name,'%')")
	List<Driver> finDrivers(String name);
	
	Optional<Driver> findByName(String name);
}
