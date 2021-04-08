package com.osm.streamiiapp.controller;

import java.time.Duration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author gg294 - 4/8/2021
 */
@RestController
public class APIController {

    @GetMapping(value = "/data/flux", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Object> streamDataFlux() {
        return Flux.interval( Duration.ofSeconds(1)).map(i -> "Data stream line - " + i );
    }
}
