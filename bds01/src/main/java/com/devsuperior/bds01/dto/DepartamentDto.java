package com.devsuperior.bds01.dto;

import com.devsuperior.bds01.entities.Department;

public class DepartamentDto {
    private Long id;
    private String name;

    public DepartamentDto() {
    }

    public DepartamentDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartamentDto(Department entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
