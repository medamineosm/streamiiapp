package com.osm.streamiiapp.config;

import com.osm.streamiiapp.handler.SocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author gg294 - 4/8/2021
 */
@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers( WebSocketHandlerRegistry registry) {
        registry.addHandler(new SocketHandler(), "/socket")
                .setAllowedOrigins("*");
    }
}
