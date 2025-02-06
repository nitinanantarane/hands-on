package com.course.springai_vector_search_text_files.service;

import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AIService {

    @Autowired
    VectorStore vectorStore;

    @Value("classpath:/data/story.txt")
    private Resource textResource;

    @Value("classpath:/prompt/system.st")
    private Resource systemPrompt;

    public List<Document> loadText(String query) {
        TextReader textReader = new TextReader(textResource);
        textReader.getCustomMetadata().put("filename", "sample.txt");
        List<Document> documents0 = textReader.get();
        List<Document> documents = new TokenTextSplitter().apply(documents0);
        vectorStore.add(documents);
        List<Document> results = vectorStore.similaritySearch(
                SearchRequest.defaults()
                        .withQuery(query)
                        .withTopK(4)
                        .withSimilarityThreshold(0.75)
        );

        System.out.println(results.get(0).getContent());
        return results;
    }

    public Message getSystemMessage(List<Document> similarDocuments) {
        String documents = similarDocuments.stream()
                .map(entry -> entry.getContent())
                .collect(Collectors.joining(System.lineSeparator()));

        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(systemPrompt);
        Message systemMessage = systemPromptTemplate.createMessage(Map.of("documents", documents));
        System.out.println(systemMessage.getContent());
        return systemMessage;
    }

    public List<Document> getQueryDocsSR(String query) {

        // read text file
        TextReader textReader = new TextReader(textResource);

        // convert the text into Document object
        List<Document> documents = textReader.get();

        System.out.println(documents);

        // chunking of text
        var textSplitter = new TokenTextSplitter();

        // add it into vector store
        vectorStore.add(textSplitter.apply(documents));

        // vector search
        List<Document> results = vectorStore.similaritySearch(
                SearchRequest.defaults()
                        .withQuery(query)
                        .withTopK(1)
                        .withSimilarityThreshold(0.8)
        );

        return results;
    }
}
