package com.devsuperior.movieflix.controller;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieDetailDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<Page<MovieDTO>> findAll(
            @RequestParam(name = "genreId", defaultValue = "0") Long genreId,
            @PageableDefault(sort = "title", direction = Sort.Direction.ASC, page = 0, size = 12) Pageable pageable) {
        Page<MovieDTO> page = service.find(genreId, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDetailDTO> findById(@PathVariable Long id) {
        MovieDetailDTO movieDTO = service.findById(id);
        return ResponseEntity.ok(movieDTO);
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewDTO>> findReviews(@PathVariable Long id) {
        List<ReviewDTO> reviews = service.findReviews(id);
        return ResponseEntity.ok().body(reviews);
    }
}
