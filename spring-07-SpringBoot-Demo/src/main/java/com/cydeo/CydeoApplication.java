package com.cydeo;

import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CydeoApplication {
	// This is my Configuration Class

	public static void main(String[] args) {

		Comment comment = new Comment();
		comment.setAuthor("Jhonson");
		comment.setText("Spring Framework");

		ApplicationContext container = SpringApplication.run(CydeoApplication.class, args);
		//SpringApplication.run(CydeoApplication.class, args);
		// This portion is creating container for you

		CommentService commentService = container.getBean(CommentService.class);
		commentService.publishComment(comment);
		commentService.printConfigData();
		commentService.printDbConfigData();
	}

}
