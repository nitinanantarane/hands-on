package com.thinkinginjava.springai_chatadvisor.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AIConfig {
    @Bean
    ChatMemory chatMemory() {
        return new InMemoryChatMemory();
    }

    @Bean
    ChatClient chatClient(ChatClient.Builder builder, ChatMemory chatMemory) {
        return builder
                .defaultSystem("You are a helpful travelling assistant!")
                .defaultAdvisors(
                        new MessageChatMemoryAdvisor(chatMemory),
                        new SafeGuardAdvisor(List.of(
                                "illegal", "smuggling", "weapons", "drugs"
                        )),
                        new SimpleLoggerAdvisor()
                ).build();
    }
}
