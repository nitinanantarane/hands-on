package com.course.springai_vector_search_text_files.controller;

import com.course.springai_vector_search_text_files.service.AIService;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ai")
public class AIController {
    @Autowired
    AIService aiService;

    @Autowired
    ChatModel chatModel;

    @PostMapping("/chat")
    public Map<String, String> getResourceFromText(@RequestParam String query){
        List<Document> similarDocuments = aiService.loadText(query);
        UserMessage userMessage = new UserMessage(query);
        Message systemMessage = aiService.getSystemMessage(similarDocuments);
        Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
        return Map.of("response", chatModel.call(prompt).getResult().getOutput().getContent());
    }

}
