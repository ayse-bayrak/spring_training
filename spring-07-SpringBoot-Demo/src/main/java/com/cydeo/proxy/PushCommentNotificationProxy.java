package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PUSH")
public class PushCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("sending push notification for comment: "+ comment.getText());
    }

    // first question? is has a ? there is not has a relationship
    // second question? if this class somewhere else basically other class requires this class
    // yes whenever you say CommentNotificationProxy one of the implementation this interface needs to be CommentService
    // then we put @Component
}
