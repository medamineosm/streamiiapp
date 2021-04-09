package com.osm.streamiiapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.osm.streamiiapp")
public class StreamiiappApplication {

    public static void main( String[] args ) {
        SpringApplication.run( StreamiiappApplication.class, args );
    }

}
