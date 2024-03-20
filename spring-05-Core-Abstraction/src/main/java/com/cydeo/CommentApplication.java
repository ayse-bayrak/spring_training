package com.cydeo;

public class CommentApplication {
    public static void main(String[] args) {

    }
}
// always put your runner under the main/base package which is Cydeo
// what's responsibility?
//run the publishComment() method, how i need to execute this method?
// we need to create first object from the CommentService and then .publishComment()
//this is Java, but it is not good structure, because I am creating so mush tightly coupling structure
// we can not handle this, so we use Spring
//define the bean