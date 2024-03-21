package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
// CommentService is requesting one Object belongs to CommentNotificationProxy
//(CommentNotificationProxy commentNotificationProxy)

@Component
@Qualifier("EMAIL")
public class EmailCommentNotificationProxy implements CommentNotificationProxy{
    @Override

    //there is not has a relationship
    //second question? if this class somewhere else basically other class requires this class
    // yes whenever you say CommentNotificationProxy one of the implementation this interface needs to be CommentService
    public void sendComment(Comment comment) {
        System.out.println("Sending notification for comment: " + comment.getText() );
    }
}
