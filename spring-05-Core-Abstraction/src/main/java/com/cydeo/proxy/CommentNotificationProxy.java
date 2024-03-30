package com.cydeo.proxy;

import com.cydeo.model.Comment;
// bean is a Java Object, @Component use to create Object, So
// Interfaces does not accept @Component, because we can not create an Object..
// external things, outside the word


public interface CommentNotificationProxy {
    void sendComment(Comment comment);

    // it will send the Comment. what is ok, is known, sendComment.
    // send it to where? I don't know
    //who's going to tell me the information about implementation?
    //Go to class which is implementing this interface
}
