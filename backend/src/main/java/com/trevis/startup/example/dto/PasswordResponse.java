package com.trevis.startup.example.dto;

import java.util.List;

public record PasswordResponse(String message, List<String> errors) { }