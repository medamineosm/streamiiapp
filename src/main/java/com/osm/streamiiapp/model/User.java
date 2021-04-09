package com.osm.streamiiapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private Byte picture;
    private String about;
}
