package com.trevis.startup.example.dto.response;

import java.util.List;

public record DataResponse<T>(
    String message,
    List<T> data
){ }
