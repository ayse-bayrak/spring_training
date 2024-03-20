package com.cydeo.repository;

import com.cydeo.model.Comment;
import org.springframework.stereotype.Component;
// CommentService is requesting one Object belongs to CommentRepository
//(CommentRepository commentRepository) so needs to be @Component

@Component
public class DBCommentRepository implements CommentRepository{
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: "+ comment.getText());
    }
}
