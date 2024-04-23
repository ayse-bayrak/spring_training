package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") //==> it can be written like this
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
// if it is SCOPE_PROTOTYPE
// if it is Singleton Spring always is going to give me the same object from the container
// if it is Prototype Spring always is going to create one more object from the container
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