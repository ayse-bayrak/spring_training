package com.cydeo.repository;

import com.cydeo.model.Comment;
// bean is an Java Object, @Component use to create Object, So
// Interfaces does not accept @Component, because we can not create an Object..
public interface CommentRepository {
    void storeComment(Comment comment);

}
// store comment where, i don' t know
//who is gonna give this information
//class whis is implementing this interface
