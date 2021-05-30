package com.sidenet.prueba.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sidenet.prueba.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
	@Query("FROM Car WHERE tradeMark LIKE CONCAT('%',:filter,'%') OR model LIKE CONCAT('%',:filter,'%') OR plaque LIKE CONCAT('%',:filter,'%')")
	List<Car> findByFilter(String filter);
	
	Optional<Car> findByPlaque(String plaque);
}
