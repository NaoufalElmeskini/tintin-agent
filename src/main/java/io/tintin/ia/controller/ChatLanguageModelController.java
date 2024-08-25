package io.tintin.ia.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
class ChatLanguageModelController {
    String LINE_BREAK = "\n";

    ChatLanguageModel chatLanguageModel;

    ChatLanguageModelController(ChatLanguageModel chatLanguageModel) {
        this.chatLanguageModel = chatLanguageModel;
    }

    @GetMapping("/model")
    public String model(@RequestParam(value = "message", defaultValue = "Hello") String message) {
        return chatLanguageModel.generate(message);
    }

    @GetMapping(value = "/scAlbert/ask",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> model(@RequestBody QueryToAlbert query) {
        ChatMemory memory = MessageWindowChatMemory.withMaxMessages(10);

        ChatMessage systemMessage = SystemMessage.from(
                query.getGoal() + LINE_BREAK
                        + query.getRole()
        );
        memory.add(systemMessage);

        memory.add(UserMessage.from(query.getContexte()));
        memory.add(UserMessage.from(query.getQuestion()));

            AiMessage response = chatLanguageModel.generate(memory.messages()).content();
        return ok(response.text());
    }
}
