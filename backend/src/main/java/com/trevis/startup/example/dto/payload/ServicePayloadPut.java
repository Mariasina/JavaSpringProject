package com.trevis.startup.example.dto.payload;

public record ServicePayloadPut(
    String name,
    String description,
    Boolean internal
){ }
