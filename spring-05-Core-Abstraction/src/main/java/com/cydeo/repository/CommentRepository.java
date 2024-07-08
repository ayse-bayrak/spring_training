package com.cydeo.repository;

//Repository packages is the place where all the database related activities, saving,update, delete
import com.cydeo.model.Comment;
// Bean is a Java Object, @Component use to create Object, So
// Interfaces does not accept @Component, because we can not create an Object from interface
public interface CommentRepository {
    void storeComment(Comment comment);

}
// store comment where, i don' t know
// who is gonna give this information
// class which is implementing this interface
