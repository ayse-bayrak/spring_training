package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.proxy.EmailCommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import com.cydeo.repository.DBCommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
//ACTUAL, ACTION PART
// service==> we are putting all our user story, whatever you need to do it in the application
// for example in here what is responsibility in this application as a developer
// we need to create publishComment. This one is unique
//This is user story
// when we go to company if we want to understand how application works, we go to Service package
//we see what they do, Service package is the place where we are building our user story
@Component
public class CommentService {  // always only you need to put interfaces
//do we have any class has a relationship? yes
    //why comment service is bean, beacsue when the application is running those objects, service objectsm
    //repository objects all of them is working. Spring needs those objects and since
    //I leave the management of creation of the object whenever it's required to calling those objects spring is just using
    //Those actual action objects we can say making functionaltiy up and runnnig, they are going inside the container
    //but the rest which is the model package or DTO package data transfer they are not gonna go under Spring

    private final CommentRepository commentRepository;// being final it is a good practice, because we might forget Constructor
    // and then can not be injection, it is bad especially for big APP
    // it is a good practice because it reminds me Constructor or if add new field, it reminds me add new field to Constructor
    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
// Service ==> unique stuff, business logic
// that is your responsibility
// publishComment() is basically my business logic