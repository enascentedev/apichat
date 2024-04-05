package com.emanuel.apichatmaterias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuel.apichatmaterias.model.Assunto;
import com.emanuel.apichatmaterias.model.Materia;
import com.emanuel.apichatmaterias.repository.AssuntoRepository;
import com.emanuel.apichatmaterias.repository.MateriaRepository;

@Service
public class AssuntoService {

	@Autowired
	private AssuntoRepository assuntoRepository;
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	public Assunto getById(Long id) {
		return assuntoRepository.findById(id).get();
	}
	
	public List<Assunto> getAll(){
		return assuntoRepository.findAll();
	}
	
	public Assunto save(Assunto assunto) {
		
		Materia materia = materiaRepository.findById(assunto.getMateria().getId()).get();
		assunto.setMateria(materia);
		
		return assuntoRepository.save(assunto);
	}
}
