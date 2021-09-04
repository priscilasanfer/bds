package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.User;

public class UserDto {
    private Long id;
    private String email;
    private String name;

    public UserDto() {
    }

    public UserDto(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public UserDto(User entity) {
        id = entity.getId();
        email = entity.getEmail();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
