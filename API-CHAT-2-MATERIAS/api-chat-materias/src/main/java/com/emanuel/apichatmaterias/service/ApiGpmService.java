package com.emanuel.apichatmaterias.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

import com.emanuel.apichatmaterias.model.QuestionResponse;

@Service
public class ApiGpmService {

	private static final String API_KEY = "coloque sua chave";
	private static final String MODEL = "gpt-3.5-turbo";
	private static final String ROLE = "user";
	
	public QuestionResponse generate(String prompt) {
		
		OpenAiService service = new OpenAiService(API_KEY);
		
		ChatMessage chat = new ChatMessage(ROLE, prompt);
		
		ChatCompletionRequest request = ChatCompletionRequest.builder()
				.messages(List.of(chat))
				.n(1)
				.temperature(0.7)
				.model(MODEL)
				.build();
		
		QuestionResponse response  = new QuestionResponse();
		response.setChoices(service.createChatCompletion(request).getChoices());
		
		return response;
	}
}
