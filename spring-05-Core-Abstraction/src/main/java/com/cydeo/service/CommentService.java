package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.proxy.EmailCommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import com.cydeo.repository.DBCommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
//service==>whatever that makes application unique
//actual action part
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