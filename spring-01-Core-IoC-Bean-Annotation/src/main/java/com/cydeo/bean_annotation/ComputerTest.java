package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.RandomConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        System.out.println("Creating Container");
        //Container is the place, the box the pull container that spring is creating object and putting inside the container.

        //Creating container by using Application Context
        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class, RandomConfig.class);
        // hey Spring, go this Config class, if we use @Bean annotation, and the look at the Bean over there
        // whatever configuration you want to edit, you can just say comma and put other one and comma put other one.

        //Creating container by using BeanFactory
        BeanFactory context = new AnnotationConfigApplicationContext();

        System.out.println("************Retrieving the beans******************");

        SonyMonitor sony = container.getBean(SonyMonitor.class);
        // you define the bean type, if you only have on Bean matching with your Spring, will not get confused and bring it your Bean
        DellCase dell = container.getBean(DellCase.class);
        AsusMotherboard asus = container.getBean(AsusMotherboard.class);


        // why we are getting those, because we're gonna providing this PC object
        PC myPc = new PC(dell,sony,asus);
        // there is a dependency relations between PC and other classes other objects(Case, Monitor, MotherBoard)
        //has a relation we can wire those two classes,
        // basically we can tell Spring, take this object, use it for creating other object, insert it inject it and creating the other object

        myPc.powerUp();

        dell.pressPowerButton();

        System.out.println("************Retrieving the beans******************");

//        Monitor theMonitor = container.getBean(Monitor.class);
//        Case theCase = container.getBean(Case.class);
//        Motherboard theMotherboard = container.getBean(Motherboard.class);
//
//        PC myPc2 = new PC(theCase,theMonitor,theMotherboard);

        System.out.println("************Multiple Objects******************");
        // two ways to fix for multiple object

        Monitor theMonitor2 = container.getBean("monitorSony", Monitor.class);  //DEFAULT BEAN NAME
        Monitor theMonitor3 = container.getBean("sony", Monitor.class);  //CUSTOM BEAN NAME
        Monitor theMonitor4 = container.getBean( Monitor.class);  //@Primary

        theMonitor2.toString();














    }
}
