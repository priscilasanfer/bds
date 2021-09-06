package com.devsuperior.uri2611.repository;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projection.MovieMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value = "SELECT m.id , m.name " +
            "from movies m " +
            "inner join genres g " +
            "on m.id_genres  = g.id " +
            "where g.description = :genreName")
    List<MovieMinProjection> search1 (String genreName);


    @Query("SELECT new com.devsuperior.uri2611.dto.MovieMinDTO(m.name, m.id) " +
            "FROM Movie m " +
            "WHERE m.genre.description = :genreName")
    List<MovieMinDTO> search2(String genreName);
}
