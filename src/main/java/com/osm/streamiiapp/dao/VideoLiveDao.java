package com.osm.streamiiapp.dao;

import com.osm.streamiiapp.model.VideoLive;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author gg294 - 4/8/2021
 */
@Repository
public interface VideoLiveDao extends ReactiveMongoRepository<VideoLive, String> {

}
