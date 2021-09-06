package com.devsuperior.uri2611.dto;

import com.devsuperior.uri2611.projection.MovieMinProjection;

public class MovieMinDTO {
    private String name;
    private Long id;

    public MovieMinDTO() {
    }

    public MovieMinDTO(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public MovieMinDTO(MovieMinProjection projection) {
        name = projection.getName();
        id = projection.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MovieMinDTO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
