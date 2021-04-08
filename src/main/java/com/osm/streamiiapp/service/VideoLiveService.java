package com.osm.streamiiapp.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.Duration;
import com.osm.streamiiapp.dao.VideoLiveDao;
import com.osm.streamiiapp.model.VideoLive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author gg294 - 4/8/2021
 */
@Slf4j
@Service
public class VideoLiveService {
    @Autowired
    private VideoLiveDao videoLiveDao;

    @PostConstruct
    public void initDb(){
        log.info( "Loading Database with objects" );
        for(int i=0;i<10;i++){
            VideoLive videoLive = VideoLive.builder()
                    .description("Video live Nbr " + i)
                    .duration( "00:0" + i)
                    .build();
            log.info( "Saving -> " + videoLiveDao.save( videoLive ).block() );
        }
    }
    @PreDestroy
    public void wipeData(){
        videoLiveDao.deleteAll();
        log.warn( "Wipping data from DB" );
    }
}
