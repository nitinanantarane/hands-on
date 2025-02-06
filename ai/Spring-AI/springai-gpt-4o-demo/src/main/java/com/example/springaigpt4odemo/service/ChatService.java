package com.example.springaigpt4odemo.service;


import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.model.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import java.io.IOException;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    ChatModel chatClient;


    public ChatResponse gentChatResponse(String category, String year){

        PromptTemplate promptTemplate = new PromptTemplate(
                """
                Please provide me best book for the given {category} and the {year}.
                Please do provide a summary of the book as well, the information should be 
                limited and not much in depth. Please provide the details in the JSON format
                containing this information : category, book, year, review, author, summary
                """
        );

        promptTemplate.add("category", category);
        promptTemplate.add("year", year);

        Prompt prompt = promptTemplate.create();

        return chatClient.call(prompt);

    }

    public String getImageChatReader(String query) throws IOException {
        var imageResource = new ClassPathResource("/image/api_image.png");

        var userMessage = new UserMessage(query,
                new Media(MimeTypeUtils.IMAGE_PNG, imageResource)); // media

        ChatResponse response = chatClient.call(new Prompt(userMessage));
        return response.getResult().getOutput().toString();
    }

}
