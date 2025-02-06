package com.nitin.openai.dto;

public record BookDetails(
    String category,
    String book,
    String year,
    String review,
    String author,
    String summary
){};