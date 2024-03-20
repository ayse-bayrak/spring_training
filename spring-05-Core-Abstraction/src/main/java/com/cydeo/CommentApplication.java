package com.cydeo;

import com.cydeo.config.CommentConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApplication {
    public static void main(String[] args) {


        Comment comment = new Comment();
        comment.setAuthor("Jhonson");
        comment.setText("Spring Framework");
        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);
        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);

    }
}
// always put your runner under the main/base package which is Cydeo
// what's responsibility?
//run the publishComment() method, how i need to execute this method?
// we need to create first object from the CommentService and then .publishComment()
//this is Java, but it is not good structure, because I am creating so mush tightly coupling structure
// we can not handle this, so we use Spring
//define the bean