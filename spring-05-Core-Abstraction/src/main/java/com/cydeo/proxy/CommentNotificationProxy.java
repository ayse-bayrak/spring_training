package com.cydeo.proxy;

import com.cydeo.model.Comment;
// bean is an Java Object, @Component use to create Object, So
// Interfaces does not accept @Component, because we can not create an Object..


public interface CommentNotificationProxy {
    void sendComment(Comment comment);
    // it will send the Comment. send it to where? i don't know
    //who's gonna tell me the information about implementation?
    //Go to class which is implementing this interface
}
