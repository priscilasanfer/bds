package com.devsuperior.movieflix.service;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieDetailDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repository.GenreRepository;
import com.devsuperior.movieflix.repository.MovieRepository;
import com.devsuperior.movieflix.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;
    @Autowired
    private GenreRepository genreRepository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> find(Long genreId, Pageable pageable) {
        genreId = (genreId == 0) ? null : genreId;
        Page<Movie> page = repository.find(genreId, pageable);
        // repository.findMovieByGenre(page.getContent()); TODO problem N+1
        return page.map(MovieDTO::new);
    }

    @Transactional(readOnly = true)
    public List<ReviewDTO> findReviews(Long id) {
        Movie movie = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie with id: " + id + " was not found"));
        return movie.getReviews().stream()
                .map(ReviewDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MovieDetailDTO findById(Long id) {
        Movie movie = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie with id: " + id + " was not found"));
        return new MovieDetailDTO(movie);
    }
}
