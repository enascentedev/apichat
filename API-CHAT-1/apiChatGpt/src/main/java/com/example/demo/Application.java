package chat1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    public static class ChatController {

        private static final String API_KEY = System.getenv("OPENAI_API_KEY");
        private static final String MODEL = "gpt-4-0125-preview";
        private OpenAiService service = new OpenAiService(API_KEY);

        @CrossOrigin
        @PostMapping("/pergunta")
        public String getAnswer(@RequestBody String question) {
            ChatMessage chatMessage = new ChatMessage("user", question);
            ChatCompletionRequest request = ChatCompletionRequest.builder()
                    .messages(List.of(chatMessage))
                    .n(1)
                    .temperature(0.0)
                    .maxTokens(50)
                    .model(MODEL)
                    .build();

            return service.createChatCompletion(request).getChoices().get(0).getMessage().getContent();
        }
    }
}
