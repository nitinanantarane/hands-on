package com.nitin.semantic.dto;

public record SemanticOutputDto(
     String source_string,
     String destination_string,
     int match_score
) {};
