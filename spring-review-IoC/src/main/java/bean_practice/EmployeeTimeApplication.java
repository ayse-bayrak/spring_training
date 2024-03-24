package bean_practice;

import bean_practice.config.EmployeeConfig;
import bean_practice.config.StringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeTimeApplication {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(EmployeeConfig.class, StringConfig.class);

        FullTimeEmployee fullTimeEmployee = container.getBean(FullTimeEmployee.class);
        PartTimeEmployee partTimeEmployee = container.getBean(PartTimeEmployee.class);

        String string1 = container.getBean("welcome", String.class);
        String string2 = container.getBean("practice", String.class);

        fullTimeEmployee.createAccount();
        partTimeEmployee.createAccount();
        System.out.println(string1);
        System.out.println(string2);


    }



}
