package com.emanuel.apichatmaterias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emanuel.apichatmaterias.model.Assunto;
import com.emanuel.apichatmaterias.service.AssuntoService;


@RestController
@RequestMapping(value = "/assuntos")
public class AssuntoController {

	@Autowired
	private AssuntoService assuntoService;
	
	@PostMapping
	public ResponseEntity<Assunto> save(@RequestBody Assunto assunto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(assuntoService.save(assunto));
	}
	
	@GetMapping
	public ResponseEntity<List<Assunto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(assuntoService.getAll());
	}
	
}
