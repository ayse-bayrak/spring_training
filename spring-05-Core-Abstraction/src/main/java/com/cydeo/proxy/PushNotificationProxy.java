package com.cydeo.proxy;

import com.cydeo.model.Comment;

public class PushNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("sending push notification for comment: "+ comment.getText());
    }
}
