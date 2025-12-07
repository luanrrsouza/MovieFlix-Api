package com.movieflix.movieflix.controller;



import com.movieflix.movieflix.controller.request.StreamingRequest;

import com.movieflix.movieflix.controller.response.StreamingResponse;

import com.movieflix.movieflix.entity.Streaming;

import com.movieflix.movieflix.mapper.StreamingMapper;
import com.movieflix.movieflix.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService streamingService;


    @GetMapping
    public ResponseEntity<List<StreamingResponse>> getAllStreamings(){
        List<Streaming> streamings = streamingService.findAll();
        List<StreamingResponse> list = streamings.stream().map(StreamingMapper::toStreamingResponse).toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> saveStreaming(@RequestBody StreamingRequest request) {
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming savedStreaming = streamingService.saveStreaming(newStreaming);

        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedStreaming));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getStreamingById(@PathVariable Long id){
        return streamingService.findById(id).map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming))).orElse(ResponseEntity.notFound().build());


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStreamingById(@PathVariable Long id){
        streamingService.deleteStreamingById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
