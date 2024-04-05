package com.emanuel.apichatmaterias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuel.apichatmaterias.model.Materia;
import com.emanuel.apichatmaterias.repository.MateriaRepository;

@Service
public class MateriaService {

	@Autowired
	private MateriaRepository materiaRepository;
	
	public Materia getById(Long id) {
		return materiaRepository.findById(id).get();
	}
	
	public List<Materia> getAll(){
		return materiaRepository.findAll();
	}
	
	public Materia save(Materia materia) {
		return materiaRepository.save(materia);
	}
}
