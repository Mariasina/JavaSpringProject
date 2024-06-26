package com.trevis.startup.example.dto.payload;

public record ServicePayload(
    String name,
    String description,
    Boolean internal
){ }
