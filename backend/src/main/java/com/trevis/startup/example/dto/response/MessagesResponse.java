package com.trevis.startup.example.dto.response;

import java.util.List;

public record MessagesResponse(
    List<String> messages
) { }
