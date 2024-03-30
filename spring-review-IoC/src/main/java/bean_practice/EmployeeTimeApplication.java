package bean_practice;

import bean_practice.config.EmployeeConfig;
import bean_practice.config.StringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeTimeApplication {
    public static void main(String[] args) {
        // hey spring, please create container based on my config class which is EmployeeConfig
        ApplicationContext container = new AnnotationConfigApplicationContext(EmployeeConfig.class, StringConfig.class);

        //call my bean from my class FullTimEmployee and PartTImeEmployee
        FullTimeEmployee fullTimeEmployee = container.getBean(FullTimeEmployee.class);
        PartTimeEmployee partTimeEmployee = container.getBean(PartTimeEmployee.class);

        String string1 = container.getBean("welcome", String.class); // we can specify here with default name which is method name"
        String string2 = container.getBean("practice", String.class);

//        String string1 = container.getBean("Message 1", String.class); // we can specify here with "name"
//        String string2 = container.getBean("Message 2", String.class);

        fullTimeEmployee.createAccount();
        partTimeEmployee.createAccount();
        System.out.println(string1);
        System.out.println(string2);


    }



}
