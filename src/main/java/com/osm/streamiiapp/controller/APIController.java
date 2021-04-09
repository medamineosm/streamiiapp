package com.osm.streamiiapp.controller;

import com.osm.streamiiapp.dao.VideoLiveDao;
import com.osm.streamiiapp.model.VideoLive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author gg294 - 4/8/2021
 */
@Slf4j
@RequestMapping("/api/stream")
@RestController
public class APIController {

    private static final long DELAY_PER_ITEM_MS = 100;

    @Autowired
    private VideoLiveDao videoLiveDao;

    @GetMapping(value = "/data/flux", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Object> streamDataFlux() {
        return Flux.interval( Duration.ofSeconds(1)).map(i -> "Data stream line - " + i );
    }

    @GetMapping(value = "/json/flux", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<VideoLive> streamJsonObjects(){
        return videoLiveDao.findAll().delayElements(Duration.ofMillis(DELAY_PER_ITEM_MS));
    }
}
