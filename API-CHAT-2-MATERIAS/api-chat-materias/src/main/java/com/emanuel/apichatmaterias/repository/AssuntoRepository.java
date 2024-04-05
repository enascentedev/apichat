package com.emanuel.apichatmaterias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emanuel.apichatmaterias.model.Assunto;

@Repository
public interface AssuntoRepository extends JpaRepository<Assunto, Long>{

}
