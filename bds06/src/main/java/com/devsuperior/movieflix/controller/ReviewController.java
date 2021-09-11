package com.devsuperior.movieflix.controller;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping
    @PreAuthorize("hasAnyRole('MEMBER')")
    public ResponseEntity<ReviewDTO> insert(@RequestBody @Valid ReviewDTO dto) {
        ReviewDTO response = service.insert(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
