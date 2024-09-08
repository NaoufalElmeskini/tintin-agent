package io.tintin.ia.controller;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
class ChatLanguageModelController {
    ChatLanguageModel chatLanguageModel;
    Agent albertAgent ;

    ChatLanguageModelController(ChatLanguageModel chatLanguageModel) {
        this.chatLanguageModel = chatLanguageModel;
        ChatMemory memory = MessageWindowChatMemory.withMaxMessages(10);
        albertAgent = AiServices.builder(Agent.class)
                .chatLanguageModel(chatLanguageModel)
                .chatMemory(memory)
                .build();
    }

    @GetMapping(value = "/generic/chat",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> model(@RequestBody QueryToAlbert query) {
        return ok(albertAgent.chat(query.getQuestion()));
    }

}
