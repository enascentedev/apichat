package com.emanuel.apichatmaterias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emanuel.apichatmaterias.model.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long>{

}
