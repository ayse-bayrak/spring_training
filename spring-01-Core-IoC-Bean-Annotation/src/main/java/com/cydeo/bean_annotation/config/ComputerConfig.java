package com.cydeo.bean_annotation.config;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.monitorfactory.AcerMonitor;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
// Configuration is the way or the ways to tell Spring which classes I want Spring manage
// if the object manage by Spring, it is called Bean,
// Bean is the objects that is manage by the Spring that we have the container
// if you want to tell hey Spring this are the objects that I want you to manage (these are the beans)
// we need to create a method, that is returning the objects that you want Spring to add containers
//and then that method with the @Bean

@Configuration  // this annotation is used to lable the class to make that class as a Configuration class where we gonna defines our beans
public class ComputerConfig {

    @Bean(name="sony")  // this annotation is used to label the methods that are returning objects
    //CUSTOM BEAN NAME
    // so we are in the implementatipn we are responsible for using new keyword one time create object on time,
    // the rest will handled by Spring
    public Monitor monitorSony(){
        return new SonyMonitor("25 inch Beast","Sony",25);
    }
    //DEFAULT BEAN NAME
    @Bean(name="sony2") // giving name to your Bean, custom name
    public Monitor monitorSony2(){
        return new SonyMonitor("40 inch Beast","Sony",40);
    }

    /*
    if you would like to use static always same bean we can use Primary,
    if you would like to adopt the bean in different situation we can use bean Name
     */
    @Bean
    @Primary // to make default
    public Monitor monitorAcer(){
        return new AcerMonitor("23 inch Beast","Acer",23);
    }
    //@Primary BEAN

    @Bean
    public Case caseDell(){
        return new DellCase("220B","Dell","240");
    }

    @Bean
    public Motherboard motherboardAsus(){
        return new AsusMotherboard("BJ-200","Asus",4,6,"v2.44");
    }




}
