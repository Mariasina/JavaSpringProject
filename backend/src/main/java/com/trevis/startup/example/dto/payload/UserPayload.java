package com.trevis.startup.example.dto.payload;

import com.trevis.startup.example.model.RoleEnum;

public record UserPayload(
    String login,
    Long department,
    RoleEnum role
) {}
