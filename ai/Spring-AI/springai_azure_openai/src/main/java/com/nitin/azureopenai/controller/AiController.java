package com.nitin.azureopenai.controller;

import com.nitin.azureopenai.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/azure/ai")
public class AiController {

    @Autowired
    private AiService aiService;

    @PostMapping("/query")
    public String getResponse(@RequestParam String category, String year) {
        return aiService.getBooks(category, year);
    }
}
