package com.devsuperior.movieflix.service;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repository.MovieRepository;
import com.devsuperior.movieflix.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {
    @Autowired
    private AuthService authService;

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public ReviewDTO insert(ReviewDTO dto) {
        User user = authService.authenticaded();

        Movie movie = movieRepository.getOne(dto.getMovieId());

        Review review = new Review();
        review.setText(dto.getText());
        review.setMovie(movie);
        review.setUser(user);

        review = repository.save(review);
        return new ReviewDTO(review);
    }
}
