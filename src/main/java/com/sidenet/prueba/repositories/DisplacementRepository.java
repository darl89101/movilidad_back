package com.sidenet.prueba.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sidenet.prueba.entities.Displacement;

@Repository
public interface DisplacementRepository extends JpaRepository<Displacement, Integer> {
	@Query("FROM Displacement WHERE plaque LIKE CONCAT('%',:filter,'%') OR origin LIKE CONCAT('%',:filter,'%') OR destination LIKE CONCAT('%',:filter,'%')")
	List<Displacement> findByFilter(String filter);

	Optional<Displacement> findByPlaque(String plaque);
}
