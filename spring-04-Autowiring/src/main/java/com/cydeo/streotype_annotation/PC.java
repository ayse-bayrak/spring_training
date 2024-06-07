package com.cydeo.streotype_annotation;

import com.cydeo.streotype_annotation.casefactory.Case;
import com.cydeo.streotype_annotation.monitorfactory.Monitor;
import com.cydeo.streotype_annotation.motherboardfactory.Motherboard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// we have tree type of implements dependency injections
//1-constructor injection
//2-field injection
//3-setter injection

@Getter
@Component
//@AllArgsConstructor // you can use this structure, that time you should delete constructor
public class PC {  // new PC(case, monitor, motherboard) when I put @Component Spring is gonna do the injection for us,
    //But it does not do injection with the int primitives
    //@Autowired ==> injecting the values through the class fields, it did not need to mark Spring version 4.3..
    private Case theCase;
    //@Autowired
    private Monitor monitor;
    //@Autowired
    private Motherboard motherboard;

    //Starting with Spring version 4.3, when you only have one constructor in the class,
    //you can omit writing the @Autowired annotation.

   //@Autowired ==> injecting the values through the constructor, it did not need to mark Spring version 4.3..
    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }
    // Spring says whenever you create a Constructor,
    // I will do all dependency injection for you (if you have one constructor)

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        // Fancy graphics
        monitor.drawPixelAt();
    }

}
