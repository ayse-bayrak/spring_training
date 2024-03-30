package bean_practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringConfig {

    //when we dont have control, when the class is not ours, like String class
/*
if we would like to full manage the beans we use beans annotation,
if we would like to spring manage the control the beans we use Streortype
because component creating beans, we dont define one by one
 */
    //@Bean(name = "Message 1") also you defined name
    @Bean
    public String welcome() {
        return "Welcome to Cydeo";
    }

    @Bean
    public String practice() {
        return "Spring Core Practice";
    }

}
