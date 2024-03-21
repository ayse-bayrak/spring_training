package com.cydeo.model;

import lombok.Data;
//Model/Entity Object never get @Component, because no need inject this one
@Data
public class Comment {
    private String author;
    private String text;
}

//
// Model/Entity whatever that Object is travelling in the Application,
// it is basic pojo, every pojo has certain fields
//You only put the corresponding fields, nothing else.
// Usually these Model don't include any method
// Just fields..
