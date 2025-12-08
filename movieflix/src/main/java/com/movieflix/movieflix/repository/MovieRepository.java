package com.movieflix.movieflix.repository;

import com.movieflix.movieflix.entity.Category;
import com.movieflix.movieflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m JOIN m.categories c WHERE c IN :categories")
    List findMovieByCategories(@Param("categories") List categories);



}
