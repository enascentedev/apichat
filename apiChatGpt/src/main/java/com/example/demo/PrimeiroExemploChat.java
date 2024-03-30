package chat1;

import java.util.List;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

public class PrimeiroExemploChat {
    private static final String API_KEY = "use a sua :)";
    private static final String MODEL = "gpt-4-0125-preview";

    public static void main(String[] args) {


        OpenAiService service= new OpenAiService(API_KEY);

        ChatMessage chat = new ChatMessage("user", "Gere um slogan para uma loja de artigos de futebol");

        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .messages(List.of(chat))
                .n(1)
                .temperature(0.0)
                .maxTokens(50)
                .model(MODEL)
                .build();

        System.out.println(service.createChatCompletion(request).getChoices().get(0).getMessage().getContent());

    }

}
