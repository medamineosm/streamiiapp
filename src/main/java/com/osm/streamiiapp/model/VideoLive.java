package com.osm.streamiiapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author gg294 - 4/8/2021
 */
@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoLive {

    @Id
    private String id;
    private String description;
    private String duration;
}
