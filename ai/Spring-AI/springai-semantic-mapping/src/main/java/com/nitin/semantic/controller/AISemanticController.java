package com.thinkinginjava.semantic.controller;

import com.thinkinginjava.semantic.dto.SemanticOutputDto;
import com.thinkinginjava.semantic.dto.SemanticRequestDto;
import com.thinkinginjava.semantic.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ai")
public class AISemanticController {

    @Autowired
    private AIService aiService;

    @GetMapping("/v0/match")
    public String getSemanticMapper() {
        List<String> sourceList = List.of(
                "What is your   first name?",
                "When is your birthday?",
                "Where were you born?",
                "What is your favorite color?",
                "Which genre of music do you prefer?",
                "What type of cuisine do you enjoy the most?",
                "What's your hobby?",
                "What is your dream job?",
                "Which sport do you like watching?",
                "What's your go-to relaxation activity?"
        );

        List<String> destinationList = List.of(
                "Your date of birth, please?",
                "The place of your birth?",
                "May I know your given name?",
                "Your music taste?",
                "Your preferred color?",
                "Your favored culinary style?",
                "Any pastimes you engage in?",
                "Your ideal career?",
                "Favorite sport to follow?",
                "How do you like to unwind?"
        );

//        List<String> sourceList = requestDto.getSourceList();
//        List<String> destinationList = reqeustDto.getDestinationList();

        return aiService.getSemanticMatch(sourceList, destinationList);
    }

    @PostMapping("/v1/match")
    public List<SemanticOutputDto> getSemanticMapperV1(@RequestBody SemanticRequestDto semanticRequestDto) {
        /*List<String> sourceList = List.of(
                "What is your   first name?",
                "When is your birthday?",
                "Where were you born?",
                "What is your favorite color?",
                "Which genre of music do you prefer?",
                "What type of cuisine do you enjoy the most?",
                "What's your hobby?",
                "What is your dream job?",
                "Which sport do you like watching?",
                "What's your go-to relaxation activity?"
        );

        List<String> destinationList = List.of(
                "Your date of birth, please?",
                "The place of your birth?",
                "May I know your given name?",
                "Your music taste?",
                "Your preferred color?",
                "Your favored culinary style?",
                "Any pastimes you engage in?",
                "Your ideal career?",
                "Favorite sport to follow?",
                "How do you like to unwind?"
        );
*/
        List<String> sourceList = semanticRequestDto.sourceList();
        List<String> destinationList = semanticRequestDto.destinationList();

        return aiService.getSemanticMatchV1(sourceList, destinationList);
    }
}
