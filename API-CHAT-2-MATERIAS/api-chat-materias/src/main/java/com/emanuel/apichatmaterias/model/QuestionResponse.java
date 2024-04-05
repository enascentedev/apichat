package com.emanuel.apichatmaterias.model;

import java.util.List;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;

import lombok.Data;

@Data
public class QuestionResponse {

	
	private List<ChatCompletionChoice> choices;
}
