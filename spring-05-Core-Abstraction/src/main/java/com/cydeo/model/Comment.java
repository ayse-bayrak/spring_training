package com.cydeo.model;

// Model/Entity whatever that Object is travelling in the Application,
// it is basic pojo, every pojo has certain fields
// You only put the corresponding fields, nothing else.
// Usually these Model don't include any method, nothing
// Just fields..


import lombok.Data;
//Model side in her, comment from the user, whoever using the application
//we do not put @Component, because this is not class that spring create
//Under the model package, the classes that we have we gonna use for get the information
//or provide the information
//Model/Entity Object never get @Component, because no need inject this one, i don't need to Spring create object
//because this information will be field by user
//shortly, if you use class to get the information that class will not go to container
@Data
public class Comment {
    private String author;
    private String text;
}


