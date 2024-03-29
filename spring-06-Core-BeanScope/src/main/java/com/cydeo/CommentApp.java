package com.cydeo;

import com.cydeo.config.CommentConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp {
    public static void main(String[] args) {
        Comment comment = new Comment();
        comment.setAuthor("Jhonson");
        comment.setText("Spring Framework");
        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);


        CommentService cs1 = context.getBean(CommentService.class); //option+enter for create local variable shortcut
        CommentService cs2 = context.getBean(CommentService.class);
        System.out.println(cs1);
        System.out.println(cs2);

    }
}

