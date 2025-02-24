package com.thinkinginjava.springai_chatadvisor.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AIController {

    @Autowired
    private ChatClient chatClient;

    @PostMapping("/response")
    public String chat(@RequestParam String query) {
        return chatClient.prompt()
                .user(query)
                .call()
                .content();
    }
}
