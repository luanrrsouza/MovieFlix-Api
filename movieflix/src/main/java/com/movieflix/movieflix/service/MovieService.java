package com.movieflix.movieflix.service;


import com.movieflix.movieflix.entity.Category;
import com.movieflix.movieflix.entity.Movie;
import com.movieflix.movieflix.entity.Streaming;
import com.movieflix.movieflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public Movie save(Movie movie) {

        movie.setCategories(findCategories(movie.getCategories()));
        movie.setStreamings(findStreaming(movie.getStreamings()));
        return movieRepository.save(movie);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    private List<Category> findCategories(List<Category> categories) {
        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach((category) -> {
            categoryService.findById(category.getId()).ifPresent(categoriesFound::add);
        });

        return categoriesFound;
    }

    private List<Streaming> findStreaming(List<Streaming> streamings) {
        List<Streaming> streamingFound = new ArrayList<>();
        streamings.forEach(streaming -> {
            streamingService.findById(streaming.getId()).ifPresent(streamingFound::add);
        });
        return streamingFound;
    }
}
