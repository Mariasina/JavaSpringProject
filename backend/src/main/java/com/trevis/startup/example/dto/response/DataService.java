package com.trevis.startup.example.dto.response;

import com.trevis.startup.example.model.Service;

public record DataService(
    Long id,
    String name,
    String description,
    Boolean internal,
    Long manager_id
) { 
    public static DataService buildFromEntity(Service service) {
        return new DataService(
            service.getId(),
            service.getName(),
            service.getDescription(),
            service.getInternal(),
            service.getManager().getId()
        );
    }
}
