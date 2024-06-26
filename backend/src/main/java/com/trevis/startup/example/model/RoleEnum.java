package com.trevis.startup.example.model;

public enum RoleEnum {
    Collaborator(1l),
    Administrator(2l),
    Manager(3l);

    private Long id;

    private RoleEnum(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
