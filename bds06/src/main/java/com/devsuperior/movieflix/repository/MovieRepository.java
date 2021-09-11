package com.devsuperior.movieflix.repository;

import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT obj " +
            "FROM Movie obj " +
            "WHERE (COALESCE(:genreId) IS NULL OR obj.genre.id = :genreId)")
    Page<Movie> find(Long genreId, Pageable pageable);

    @Query("SELECT obj FROM Movie obj JOIN FETCH obj.genre where obj IN :movies")
    List<Movie> findMovieByGenre(List<Movie> movies);

}
