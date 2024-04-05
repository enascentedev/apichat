package com.emanuel.apichatmaterias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emanuel.apichatmaterias.model.AnswerRequest;
import com.emanuel.apichatmaterias.model.Assunto;
import com.emanuel.apichatmaterias.model.QuestionRequest;
import com.emanuel.apichatmaterias.model.QuestionResponse;
import com.emanuel.apichatmaterias.service.ApiGpmService;
import com.emanuel.apichatmaterias.service.AssuntoService;

@RestController
public class ApiGpmController {

	@Autowired
	private ApiGpmService apiGpmService;
	
	@Autowired
	private AssuntoService assuntoService;
	
	@PostMapping("/chat/question")
	public String getQuestion(@RequestBody QuestionRequest request){
		
		Assunto assunto = assuntoService.getById(request.getIdAssunto());
		
		String prompt = "Me faça uma pergunta de " + assunto.getMateria().getNome() + " sobre " + assunto.getNome() + ". O fomrato da resposta deve ser Pergunta: mais a descrição da pergunta.";
		
		QuestionResponse response = apiGpmService.generate(prompt);
		
		return response.getChoices().get(0).getMessage().getContent();
	}
	
	@PostMapping("/chat/answer")
	public String getAnswers(@RequestBody AnswerRequest request){

		QuestionResponse response = apiGpmService.generate(request.getPrompt());
		
		return response.getChoices().get(0).getMessage().getContent();
	}
}
