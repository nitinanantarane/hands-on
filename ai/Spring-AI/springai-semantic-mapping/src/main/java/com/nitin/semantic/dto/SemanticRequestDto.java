package com.thinkinginjava.semantic.dto;

import java.util.List;

public record SemanticRequestDto(
     List<String> sourceList,
     List<String> destinationList
) {};
