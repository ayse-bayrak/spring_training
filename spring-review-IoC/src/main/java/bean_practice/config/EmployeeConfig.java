package bean_practice.config;

import bean_practice.FullTimeEmployee;
import bean_practice.PartTimeEmployee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {
    @Bean
    public FullTimeEmployee createFullTime() {
        return new FullTimeEmployee();
    }

    @Bean
    public PartTimeEmployee createPartTime() {
        return new PartTimeEmployee();
    }

}
