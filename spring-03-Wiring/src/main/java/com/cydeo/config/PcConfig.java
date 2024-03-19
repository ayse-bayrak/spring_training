package com.cydeo.config;

import com.cydeo.casefactory.Case;
import com.cydeo.casefactory.DellCase;
import com.cydeo.casefactory.Dimensions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PcConfig {

    @Bean
    public Dimensions dimensions(){
        return new Dimensions(50,10,10);
    } // you just create the bean Dimensions in the container, and now this bean in the contaainer
    // and Spring is provided by itself..
    // this is called wiring

    @Bean
    public Case caseDell(Dimensions dimensions){ // wiring automatically happen inside
        return new DellCase("220B","Dell","240",dimensions);
        // I have in the container and I have a Dimensions bean, let me provide.. it's wiring
    }
}
