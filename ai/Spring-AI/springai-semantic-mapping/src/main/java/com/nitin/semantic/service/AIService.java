package com.nitin.semantic.service;

import com.nitin.semantic.dto.SemanticOutputDto;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AIService {

    @Autowired
    private ChatModel chatModel;

    public String getSemanticMatch(List<String> sourceList, List<String> destinationList) {
        var template = """
                You will be provided source and destination list containing strings.
                You need to take a string one by one from source list until its empty
                and try to match with string in the destination list.
                
                Please be note that you have to match the strings based on the semantic mapping
                and not just based on the the string similarity. It you are not able to find any match
                for the given text in the source list, please do say "No match found" in the destination
                string only.
                
                Please also mention the matching score based on your confidence on the mapping.
                The match score should be a number between 0-100 where 0 means no match and \s
                100 means perfect match.
                
                source list questions :
                {source_list}
                
                destination list questions :
                {destination_list}
                
                Your response :
                """;
        PromptTemplate promptTemplate = new PromptTemplate(template);
        promptTemplate.add("source_list", sourceList);
        promptTemplate.add("destination_list", destinationList);

        Prompt prompt = promptTemplate.create();

        return chatModel.call(prompt).getResult().getOutput().getContent();
    }

    public List<SemanticOutputDto> getSemanticMatchV1(List<String> sourceList, List<String> destinationList) {
        BeanOutputConverter<List<SemanticOutputDto>> beanOutputConverter =
                new BeanOutputConverter<>(new ParameterizedTypeReference<List<SemanticOutputDto>>(){});

        String format = beanOutputConverter.getFormat();

        var template = """
                You will be provided source and destination list containing strings.
                You need to take a string one by one from source list until its empty
                and try to match with string in the destination list.
                
                Please be note that you have to match the strings based on the semantic mapping
                and not just based on the the string similarity. It you are not able to find any match
                for the given text in the source list, please do say "No match found" in the destination
                string only.
                
                Please also mention the matching score based on your confidence on the mapping.
                The match score should be a number between 0-100 where 0 means no match and \s
                100 means perfect match.
                
                source list questions :
                {source_list}
                
                destination list questions :
                {destination_list}
                
                Your response :
                {format}
                """;

        PromptTemplate promptTemplate = new PromptTemplate(template);
        promptTemplate.add("source_list", sourceList);
        promptTemplate.add("destination_list", destinationList);
        promptTemplate.add("format", format);

        Prompt prompt = promptTemplate.create();

        return beanOutputConverter.convert(chatModel.call(prompt).getResult().getOutput().getContent());
    }
}
