package com.cydeo.repository;

import com.cydeo.model.Comment;
import org.springframework.stereotype.Component;
// CommentService is requesting one Object belongs to CommentRepository
//(CommentRepository commentRepository) so needs to be @Component
//how to delete, update data

@Component
public class DBCommentRepository implements CommentRepository{
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: "+ comment.getText());
    }
}
// first question? is has a ? there is not has a relationship
// second question? if this class somewhere else basically other class requires this class
// yes whenever you say CommentRepository one of the implementation this interface needs to be CommentService
// then we put @Component
