package com.cydeo.service;

import com.cydeo.config.AppConfigData;
import com.cydeo.config.DBConfigData;
import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// service==> we are putting all our user story, whatever you need to do it in the application
// for example in here what is responsibility in this application as a developer
// we need to create publishComment. This one is unique
//This is user story
// when we go to compony if we want to understand how application works, we go to Service package
//we see what they do, Servise package is the place where we are building our user story
@Component
public class CommentService {  // always only you need to put interfaces

    private final CommentRepository commentRepository;// being final it is a good practice, because we might forget Constructor
    // and then can not be injection, it is bad especially for big APP
    // it is a good practice because it remind me Constructor or if add new field, it reminds me add new field to Constructor
    private final CommentNotificationProxy commentNotificationProxy;
    private final AppConfigData appConfigData; // for injection, we need to add fields
    private final DBConfigData dbConfigData;

    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy, AppConfigData appConfigData, DBConfigData dbConfigData) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        this.appConfigData = appConfigData;
        this.dbConfigData = dbConfigData;
    }

    public void publishComment(Comment comment) {

        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);

    }

    public void printConfigData(){
        System.out.println(appConfigData.getUserName());
        System.out.println(appConfigData.getPassword());
        System.out.println(appConfigData.getUrl());
    }

    public void printDbConfigData(){
        System.out.println(dbConfigData.getUsername());
        System.out.println(dbConfigData.getPassword());
        System.out.println(dbConfigData.getType());
    }
}
// Service ==> unique stuff, business logic
// that is your responsibility
// publishComment() is basically my business logic