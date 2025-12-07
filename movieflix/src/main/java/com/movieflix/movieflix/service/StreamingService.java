package com.movieflix.movieflix.service;


import com.movieflix.movieflix.entity.Category;
import com.movieflix.movieflix.entity.Streaming;
import com.movieflix.movieflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository streamingRepository;

    public List<Streaming> findAll(){
        return streamingRepository.findAll();

    }

    public Streaming saveStreaming(Streaming streaming) {
        return streamingRepository.save(streaming);
    }

    public Optional<Streaming> findById(Long Id) {
        return streamingRepository.findById(Id);

    }

    public void deleteStreamingById(Long Id) {
        streamingRepository.deleteById(Id);
    }
}
