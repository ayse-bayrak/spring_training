package com.cydeo.streotype_annotation.casefactory;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
//@AllArgsConstructor
@Component // since I put @Component, Spring is trying to create an object
// Spring is gonna do new Dimensions,
public class Dimensions {  // Spring create new Dimensions(int int int)
    //dependency injection can not be done on the Primitives.
    //Spring says There is nothing I can inject this one

    private int width;
    private int height;
    private int depth;

    public Dimensions() {
        this.width=10;
        this.height=30;
        this.depth=40;
    }

    public void pressPowerButton(){
        System.out.println("Power button pressed");
    }
}
