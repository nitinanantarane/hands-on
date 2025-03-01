package com.nitin.azureopenai.service;

import org.springframework.ai.azure.openai.AzureOpenAiChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    @Autowired
    private AzureOpenAiChatModel chatModel;

    public String getBooks(String category, String year) {
        PromptTemplate promptTemplate = new PromptTemplate("""
                Please give me best book for the given {category} and the {year}.
                Please do provide the summary of the book as well, the information should be
                limited and not much in depth. Please provide the details in the JSON format
                containing this information: category, book, year, review, author, summary
                """);

        promptTemplate.add("category", category);
        promptTemplate.add("year", year);

        Prompt prompt = promptTemplate.create();
        return chatModel.call(prompt).getResult().getOutput().getContent();
    }
}
